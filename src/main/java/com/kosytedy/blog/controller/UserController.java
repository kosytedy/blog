package com.kosytedy.blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosytedy.blog.model.User;
import com.kosytedy.blog.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;

	// get all users
	@GetMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	// get a user by id
	@GetMapping("/{userId}")
	public Optional<User> getUser(@PathVariable(name="userId") Long userId){
		return userService.getUser(userId);
	}
	
	@GetMapping("/username")
	public Object getLoggedInUser(Authentication authentication){
		return authentication.getName();
	}
	
	// get a user by username
	@GetMapping("/username/{username}")
	public User getUserByUsername(@PathVariable(name="username") String username){
		return userService.getUserByUsername(username);
	}
	
	//create user
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	// update user
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable(name="userId") Long userId, @RequestBody User user){
		return userService.saveUser(user);
	}
	
	// delete user
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable(name="userId") Long userId){
		return userService.deleteUser(userId);
	}
}
