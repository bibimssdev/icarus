package com.k15labs.icarus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class IcarusApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcarusApplication.class, args);
	}

}
