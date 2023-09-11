package com.redesocial.RedeSocial.service;

import com.redesocial.RedeSocial.domain.Coment;
import com.redesocial.RedeSocial.domain.Post;
import com.redesocial.RedeSocial.domain.User;
import com.redesocial.RedeSocial.dto.ComentDTO;
import com.redesocial.RedeSocial.dto.PostDTO;
import com.redesocial.RedeSocial.repository.ComentReposiroty;
import com.redesocial.RedeSocial.repository.PostRepository;
import com.redesocial.RedeSocial.repository.UserRepository;
import com.redesocial.RedeSocial.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ComentReposiroty comentReposiroty;
    private final UserService userService;

    public void insert(PostDTO postDTO){
        Instant data = Instant.now();
        User user = userService.findById(postDTO.getAuthor());
        Post post = new Post(postDTO.getId(), data, postDTO.getTitle(), postDTO.getBody(), user);
        postRepository.save(post);
        user.getPosts().add(post);
        userRepository.save(user);
    }

    public Post findById(Long id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


    public void insertComent(ComentDTO comentDTO){
        Post post = findById(comentDTO.getIdPost());
        User user = userService.findById(comentDTO.getAuthor());
        Instant data = Instant.now();
        Coment coment = new Coment(comentDTO.getId(), comentDTO.getText(), data, user);
        comentReposiroty.save(coment);
        post.getComents().add(coment);
        postRepository.save(post);
    }

}
