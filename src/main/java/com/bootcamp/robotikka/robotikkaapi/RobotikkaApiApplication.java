package com.bootcamp.robotikka.robotikkaapi;

import com.bootcamp.robotikka.robotikkaapi.entity.UserRole;
import com.bootcamp.robotikka.robotikkaapi.repo.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RobotikkaApiApplication implements CommandLineRunner {

	@Autowired
	private UserRoleRepo userRoleRepo;

	public static void main(String[] args) {
		SpringApplication.run(RobotikkaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long count = userRoleRepo.count();
		if (count==0){
			UserRole role1 = new UserRole("UR-1","ADMIN","Super Privileges",null);
			UserRole role2 = new UserRole("UR-2","MANAGER","Management Privileges",null);
			UserRole role3 = new UserRole("UR-3","USER","regular user",null);
			// save new user role
		}

	}
}
