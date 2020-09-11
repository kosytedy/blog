package com.kosytedy.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kosytedy.blog.exception.ResourceNotFoundException;
import com.kosytedy.blog.model.User;
import com.kosytedy.blog.repository.UserRepository;

import net.minidev.json.JSONObject;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUser(Long userId){
		return Optional.of(userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException(userId)));
	}
	
	public User getUserByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public User saveUser(User user){
		if(!userRepository.existsById(user.getId())) {
			user.setPassword(bcryptEncoder.encode(user.getPassword()));
		}
		return userRepository.save(user);
	}
	
	public ResponseEntity<?> deleteUser(Long userId){
		
		if(userRepository.existsById(userId)) {
			JSONObject body = new JSONObject();
			userRepository.deleteById(userId);
			body.put("message", "User deleted successfully.");
			return ResponseEntity.ok(body);
		}
		
		throw new ResourceNotFoundException(userId);
	}
}
