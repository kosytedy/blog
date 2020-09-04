package com.kosytedy.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosytedy.blog.model.Comment;

@Repository
public interface CommentReposistory extends JpaRepository<Comment, Integer> {

	
}
