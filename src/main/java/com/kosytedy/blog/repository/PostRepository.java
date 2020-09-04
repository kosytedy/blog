package com.kosytedy.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosytedy.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
