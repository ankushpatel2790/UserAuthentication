package com.transamerica.user.auth.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.transamerica")
@EntityScan( basePackages = {"com.transamerica.user.auth.model"})
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class UserAuthenticationApplication {
	public static void main(String[] args) {

		SpringApplication.run(UserAuthenticationApplication.class, args);
	}


}
