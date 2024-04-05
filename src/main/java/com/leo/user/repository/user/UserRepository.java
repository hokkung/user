package com.leo.user.repository.user;

import com.leo.user.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameFirstName(String firstName);

    Optional<User> findByEmail(String email);
}
