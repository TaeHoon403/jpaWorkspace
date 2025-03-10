package com.kh.app0307;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class App0307Application {

	public static void main(String[] args) {
		SpringApplication.run(App0307Application.class, args);
	}

}
