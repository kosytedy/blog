package com.kosytedy.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kosytedy.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	@Query(value = "SELECT * FROM Post p WHERE p.content LIKE %:text%", nativeQuery = true)
	List<Post> searchPost(String text); 
}
