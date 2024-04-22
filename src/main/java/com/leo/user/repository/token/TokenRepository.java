package com.leo.user.repository.token;

import com.leo.user.domain.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);

    List<Token> findByUserId(long userId);

    List<Token> findByIsExpiredAndIsRevokedAndUserId(boolean isExpired, boolean isRevoked, long userId);

    default List<Token> findActiveByUserId(long userId) {
        return findByIsExpiredAndIsRevokedAndUserId(false, false, userId);
    }
}
