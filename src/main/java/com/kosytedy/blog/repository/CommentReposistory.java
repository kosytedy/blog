package com.kosytedy.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kosytedy.blog.model.Comment;

@RepositoryRestResource(collectionResourceRel = "comment", path = "comment")
public interface CommentReposistory extends JpaRepository<Comment, Integer> {

	
}
