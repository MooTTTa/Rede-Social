package com.redesocial.RedeSocial.controller;

import com.redesocial.RedeSocial.domain.User;
import com.redesocial.RedeSocial.dto.UserDTO;
import com.redesocial.RedeSocial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Long id){ return userService.findById(id); }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO userDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userService.insert(userDTO));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UserDTO userDTO, @PathVariable Long id){
        userDTO.setId(id);
        userService.update(userDTO);
    }
}
