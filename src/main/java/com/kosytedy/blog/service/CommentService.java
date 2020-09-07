package com.kosytedy.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kosytedy.blog.exception.ResourceNotFoundException;
import com.kosytedy.blog.model.Comment;
import com.kosytedy.blog.repository.CommentRepository;

import net.minidev.json.JSONObject;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public List<Comment> getComments(){
		return commentRepository.findAll();
	}
	
	public Optional<Comment> getComment(Long commentId){
		return Optional.of(commentRepository.findById(commentId))
				.orElseThrow(() -> new ResourceNotFoundException(commentId));
	}
	
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public ResponseEntity<?> deleteComment(Long commentId){
		
		if(commentRepository.existsById(commentId)) {
			JSONObject body = new JSONObject();
			commentRepository.deleteById(commentId);
			body.put("message", "Comment deleted successfully.");
			return ResponseEntity.ok(body);
		}
		
		throw new ResourceNotFoundException(commentId);
	}
}
