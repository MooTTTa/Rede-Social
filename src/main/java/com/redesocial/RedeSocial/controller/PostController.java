package com.redesocial.RedeSocial.controller;

import com.redesocial.RedeSocial.dto.PostDTO;
import com.redesocial.RedeSocial.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void insert(@RequestBody PostDTO postDTO){
        postService.insert(postDTO);
    }


}
