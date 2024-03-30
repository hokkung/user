package com.leo.user.repository.user;

import com.leo.user.domain.user.User;
import com.leo.user.testutil.user.UserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testCreate() {
        User user = UserUtils.createUser("f", "l", "f@gmail.com");

        User savedUser = underTest.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());

        Assertions.assertEquals(savedUser.getId(), existUser.getId());
    }
}