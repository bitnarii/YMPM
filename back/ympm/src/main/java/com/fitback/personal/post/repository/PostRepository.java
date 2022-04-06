package com.fitback.personal.post.repository;

import com.fitback.personal.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByPostNameContaining(String keyword);

}
