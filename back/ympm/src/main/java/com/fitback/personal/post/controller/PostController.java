package com.fitback.personal.post.controller;

import com.fitback.personal.post.dto.PostDto;
import com.fitback.personal.post.model.Post;
import com.fitback.personal.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/personal")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/add")
    public Post addPost (@RequestBody Post post) {
        return postService.addPost(post);}

    @GetMapping("/list/getAll")
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }

    @GetMapping("/searchresult")
    public List<PostDto> PostDtoList(@RequestParam(value="keyword") String keyword, Model model) {
        model.addAttribute("keyword", keyword);
         return postService.searchPosts(keyword);



//    @GetMapping("/result/list")
//    public String search(@RequestParam(value="keyword") String keyword, Model model) {
//        List<PostDto> boardDtoList = postService.searchPosts(keyword);
//
//        model.addAttribute("boardList", boardDtoList);
//
//        return "";
    }


}
