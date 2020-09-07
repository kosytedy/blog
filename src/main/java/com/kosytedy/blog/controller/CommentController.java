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

import com.kosytedy.blog.model.Comment;
import com.kosytedy.blog.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@GetMapping
	public List<Comment> getComments(){
		return commentService.getComments();
	}
	
	@GetMapping("/{commentId}")
	public Optional<Comment> getComment(@PathVariable(name="commentId") Long commentId) {
		return commentService.getComment(commentId);
	}
	
	@PostMapping("/create")
	public Comment createComment(@RequestBody Comment comment){
		return commentService.saveComment(comment);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateComment(@PathVariable(name="commentId") Long commentId, @RequestBody Comment comment){
		return commentService.saveComment(comment);
	}
	
	@DeleteMapping("/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable(name="commentId") Long commentId){
		return commentService.deleteComment(commentId);
	}
}
