package com.leo.user.service.token;

import com.leo.user.common.exception.InvalidValueException;
import com.leo.user.domain.token.Token;
import com.leo.user.domain.token.TokenInf;
import com.leo.user.domain.user.User;
import com.leo.user.model.auth.AuthenticationResult;
import com.leo.user.repository.token.TokenRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;


@Service
@Setter
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void revokeAllToken(User user) {
        transactionTemplate.executeWithoutResult((t) -> {
            List<Token> tokens = tokenRepository.findActiveByUserId(user.getId());
            tokens.forEach(Token::deactivate);
        });
    }

    @Override
    public boolean verifyToken(String tokenStr) {
        TokenInf token = tokenRepository.findByToken(tokenStr).orElseThrow();
        return token.isValid();
    }


    @Override
    public void verifyAndRevoke(String tokenStr) {
        TokenInf token = tokenRepository.findByToken(tokenStr).orElseThrow();
        if (!token.isValid()) {
            // TODO: change the exception
            throw new InvalidValueException();
        }

        token.deactivate();
    }

    @Override
    public Token create(Token token) {
        return tokenRepository.save(token);
    }

    @Override
    public Token create(AuthenticationResult authentication) {
        Token token = Token.createBearer(authentication.user());
        token.setToken(authentication.token());

        return create(token);
    }
}
