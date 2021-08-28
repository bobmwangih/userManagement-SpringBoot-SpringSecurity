package com.bob.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bob.Service.UserService;
import com.bob.model.AppUser;
import com.bob.model.Role;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>>getUsers(){
		return ResponseEntity.ok().body(userService.getUsers());
		
	}
	
	@GetMapping("/users/{userName}")
	public ResponseEntity<AppUser>getUserByUserName(@PathVariable String userName){
		return ResponseEntity.ok().body(userService.getUser(userName));
	}
	
	@PostMapping("/user/save")
	public ResponseEntity<AppUser>saveUser(@RequestBody AppUser user){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}
	
	@PostMapping("/role/save")
	public ResponseEntity<Role>saveRole(@RequestBody Role role){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
	}
	
	@PostMapping("/role/addRole")
	public ResponseEntity<Role>addRoleToUser(@RequestBody RoleToUserForm form){
		userService.addRoleToUser(form.getUserName(), form.getRoleName());
		return ResponseEntity.ok().build();
	}
	
	@Data
	class RoleToUserForm {
		private String userName;
		private String roleName;
	}
}
