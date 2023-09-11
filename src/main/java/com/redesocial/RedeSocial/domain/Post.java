package com.redesocial.RedeSocial.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Post implements Serializable {

    @Id
    private Long id;
    private Instant data;
    private String title;
    private String body;
    @JsonIgnore
    private User author;


    @DBRef(lazy = true)//carrega os posts se eu somente ascesalos
    private List<Coment> coments = new ArrayList<>();

    public Post(Long id, Instant data, String title, String body, User author) {
        this.id = id;
        this.data = data;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
