package com.bootcamp.robotikka.robotikkaapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RobotikkaApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RobotikkaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// save user role
		// save default user (must be an admin)
	}
}
