package com.fitback.personal.post.service;

import com.fitback.personal.post.dto.PostDto;
import com.fitback.personal.post.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post);
    List<Post> getAllPost();
    List<PostDto> searchPosts(String keyword);




}
