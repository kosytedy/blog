package com.kosytedy.blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosytedy.blog.model.Post;
import com.kosytedy.blog.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping
	public List<Post> getPosts(){
		return postService.getPosts();
	}
	
	@GetMapping("/{postId}")
	public Optional<Post> getPost(@PathVariable(name="postId") Long postId) {
		return postService.getPost(postId);
	}
	
	@PostMapping("/create")
	public Post createPost(@RequestBody Post post){
		return postService.savePost(post);
	}
	
	@PutMapping("/{postId}")
	public Post updatePost(@PathVariable(name="postId") Long postId, @RequestBody Post post){
		return postService.savePost(post);
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable(name="postId") Long postId){
		return postService.deletePost(postId);
	}
}
