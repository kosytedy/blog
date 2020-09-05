package com.kosytedy.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kosytedy.blog.model.User;
import com.kosytedy.blog.repository.UserRepository;

import net.minidev.json.JSONObject;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUser(Long userId){
		return Optional.of(userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with id "+ userId +" not found.")));
	}
	
	public User getUserByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public User updateUser(User user){
		return userRepository.save(user);
	}
	
	public ResponseEntity<?> deleteUser(Long userId){
		
		JSONObject body = new JSONObject();
		
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			body.put("message", "User deleted successfully.");
			return ResponseEntity.ok(body);
		}
		
		body.put("message", "User with id "+ userId +" not found.");
		return ResponseEntity.ok(body);
	}
}
