package com.backend.devsuperior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"com.backend.controllers","com.backend.services"})
@EntityScan("com.backend.entities")
@EnableJpaRepositories("com.backend.repositories")
public class DevsuperiorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevsuperiorApplication.class, args);
	}

}
