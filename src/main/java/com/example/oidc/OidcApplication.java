package com.example.oidc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OidcApplication {

	public static void main(String[] args) {
		SpringApplication.run(OidcApplication.class, args);
	}

}
