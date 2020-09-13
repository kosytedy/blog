package com.kosytedy.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kosytedy.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	@Query("SELECT * FROM post p WHERE p.content LIKE %?1%")
	List<Post> searchPost(String text);
}
