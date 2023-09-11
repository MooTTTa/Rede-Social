package com.redesocial.RedeSocial.controller;

import com.redesocial.RedeSocial.domain.Post;
import com.redesocial.RedeSocial.dto.ComentDTO;
import com.redesocial.RedeSocial.dto.PostDTO;
import com.redesocial.RedeSocial.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void insert(@RequestBody PostDTO postDTO){
        postService.insert(postDTO);
    }

    @PostMapping("/insertComent/{id}")
    public void insertComent(@RequestBody ComentDTO comentDTO, @PathVariable Long id){
        comentDTO.setIdPost(id);
        postService.insertComent(comentDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
