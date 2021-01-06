package com.backend.devsuperior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DevsuperiorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevsuperiorApplication.class, args);
	}

}
