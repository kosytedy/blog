package com.kosytedy.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kosytedy.blog.exception.ResourceNotFoundException;
import com.kosytedy.blog.model.Post;
import com.kosytedy.blog.repository.PostRepository;

import net.minidev.json.JSONObject;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public List<Post> getPosts(){
		return postRepository.findAll();
	}
	
	public Optional<Post> getPost(Long postId) {
		return Optional.of(postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(postId)));
	}
	
	public Post savePost(Post post) {
		return postRepository.save(post);
	}
	
	public ResponseEntity<?> deletePost(Long postId){
		
		if(postRepository.existsById(postId)) {
			JSONObject body = new JSONObject();
			postRepository.deleteById(postId);
			body.put("message", "Post deleted successfully.");
			return ResponseEntity.ok(body);
		}
		
		throw new ResourceNotFoundException(postId);
	}
	
	public List<Post> searchPost(String text){
		return postRepository.searchPost(text); 
	}
}
