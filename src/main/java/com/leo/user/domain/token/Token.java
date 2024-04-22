package com.leo.user.domain.token;


import com.leo.user.common.domain.AbstractAuditableEntity;
import com.leo.user.common.util.ClockUtils;
import com.leo.user.domain.user.User;
import com.leo.user.repository.token.TokenTypeConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tokens")
@Getter
@Setter
public class Token extends AbstractAuditableEntity<Long> implements TokenInf {

    @Column(name = "token")
    private String token;

    @Column(name = "type")
    @Convert(converter = TokenTypeConverter.class)
    private TokenType type;

    @Column(name = "is_expired")
    private boolean isExpired;

    @Column(name = "is_revoked")
    private boolean isRevoked;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Token() {
        setCreatedDate(ClockUtils.current());
        setUpdatedDate(ClockUtils.current());
        this.type = TokenType.BEARER;
        this.isExpired = false;
        this.isRevoked = false;
    }

    public static Token createBearer(User user) {
        Token token = new Token();
        token.setUser(user);
        return token;
    }

    public void deactivate() {
        setExpired(true);
        setRevoked(true);
    }

    public boolean isValid() {
        return !this.isExpired() || !this.isRevoked();
    }
}
