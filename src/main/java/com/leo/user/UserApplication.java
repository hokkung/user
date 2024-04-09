package com.leo.user;

import com.leo.user.config.JwtProperties;
import com.leo.user.config.RSAKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EntityScan("com.leo.user.domain.user")
@EnableConfigurationProperties({RSAKeyProperties.class, JwtProperties.class})
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
