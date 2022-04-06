package com.fitback.personal.post.service;

import com.fitback.personal.post.dto.PostDto;
import com.fitback.personal.post.model.Post;
import com.fitback.personal.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }


    @Override
    public List<PostDto> searchPosts(String keyword) {
        List<Post> posts = postRepository.findByPostNameContaining(keyword);
        List<PostDto> postDtoList = new ArrayList<>();

        if (posts.isEmpty()) return postDtoList;

        for (Post post : posts) {
            postDtoList.add(this.convertEntityToDto(post));
        }


        return postDtoList;



    }


    private PostDto convertEntityToDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .postImg(post.getPostImg())
                .postDesc(post.getPostDesc())
                .postName(post.getPostName())
                .postScore(post.getPostScore())
                .build();
    }

}

