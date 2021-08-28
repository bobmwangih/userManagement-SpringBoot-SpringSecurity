package com.bob;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bob.Service.UserService;
import com.bob.model.AppUser;
import com.bob.model.Role;

@SpringBootApplication
public class SpringBootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return args ->{
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_SUPERADMIN"));
			
			userService.saveUser(new AppUser(null , "JOHN DOE","john","123",new ArrayList<>()));
			userService.saveUser(new AppUser(null , "JANE DOE","jane","123",new ArrayList<>()));
			userService.saveUser(new AppUser(null , "JUNE DOE","june","123",new ArrayList<>()));
			userService.saveUser(new AppUser(null , "JACK DOE","jack","123",new ArrayList<>()));
			
			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("jane", "ROLE_ADMIN");
			userService.addRoleToUser("june", "ROLE_MANAGER");
			userService.addRoleToUser("jack", "ROLE_USER");
			userService.addRoleToUser("jack", "ROLE_ADMIN");
			userService.addRoleToUser("jack", "ROLE_MANAGER");
			userService.addRoleToUser("jack", "ROLE_SUPERADMIN");
		};
	}

}
