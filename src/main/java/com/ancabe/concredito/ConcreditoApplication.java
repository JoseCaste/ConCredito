package com.ancabe.concredito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ConcreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcreditoApplication.class, args);
	}

}
