package com.redesocial.RedeSocial.service;

import com.redesocial.RedeSocial.domain.Post;
import com.redesocial.RedeSocial.domain.User;
import com.redesocial.RedeSocial.dto.PostDTO;
import com.redesocial.RedeSocial.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public void insert(PostDTO postDTO){
        User user = userService.findById(postDTO.getAuthor());
        postRepository.save(new Post(postDTO.getId(), postDTO.getData(), postDTO.getTitle(), postDTO.getBody(), user));
    }

}
