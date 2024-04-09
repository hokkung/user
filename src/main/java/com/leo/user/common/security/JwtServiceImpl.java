package com.leo.user.common.security;

import com.leo.user.common.util.ClockUtils;
import com.leo.user.config.JwtProperties;
import com.leo.user.domain.user.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Setter
public class JwtServiceImpl implements JwtService {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private JwtDecoder jwtDecoder;

    @Autowired
    private JwtEncoder jwtEncoder;

    @Override
    public JwtToken generateToken(User user) {
        return generateToken(user.getEmail(),
                user.getRoles().stream().map(Enum::name).collect(Collectors.toSet()),
                null);
    }

    @Override
    public JwtToken generateToken(User user, Jwt refreshToken) {
        return generateToken(user.getEmail(),
                user.getRoles().stream().map(Enum::name).collect(Collectors.toSet()),
                refreshToken);
    }

    private JwtToken generateToken(String name, Set<String> roles, Jwt refreshToken) {
        Instant current = ClockUtils.getCurrent();
        Instant expirationTime = getExpirationTime(current);

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuedAt(current)
                .expiresAt(expirationTime)
                .subject(name)
                .claim("roles",  String.join(" ", roles))
                .build();

        if (refreshToken != null) {
            return new JwtToken(
                    jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(),
                    refreshToken.getTokenValue(),
                    new Date(expirationTime.toEpochMilli())
            );
        }

        Instant refreshExpirationTime = getRefreshExpirationTime(current);
        JwtClaimsSet refreshClaims = JwtClaimsSet.builder()
                .issuedAt(current)
                .expiresAt(refreshExpirationTime)
                .subject(name)
                .claim("roles",  String.join(" ", roles))
                .build();

        return new JwtToken(
                jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(),
                jwtEncoder.encode(JwtEncoderParameters.from(refreshClaims)).getTokenValue(),
                new Date(expirationTime.toEpochMilli())
        );
    }

    private Instant getExpirationTime(Instant current) {
        return current.plusMillis(jwtProperties.expirationTimeInMinute() * 60 * 1000);
    }

    private Instant getRefreshExpirationTime(Instant current) {
        return current.plusMillis(jwtProperties.refreshExpirationTimeInMinute() * 60 * 1000);
    }

//
//    @Override
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllCliams(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims extractAllCliams(String token) {
//        return Jwts.parser()
//                .verifyWith(getSignInKey())
//                .build()
//                .parseClaimsJws(token)
//                .getPayload();
//    }
//
//    private SecretKey getSignInKey() {
//        byte[] bytes = Decoders.BASE64.decode(jwtSecretKey);
//        return Keys.hmacShaKeyFor(bytes);}
//
//    @Override
//    public boolean IsTokenValid(String token, UserDetails userDetails) {
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }

}
