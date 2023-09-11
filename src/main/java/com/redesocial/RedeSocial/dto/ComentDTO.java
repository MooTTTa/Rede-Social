package com.redesocial.RedeSocial.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComentDTO implements Serializable {
    private Long idPost;
    @NotNull
    private Long id;
    @NotNull
    private String text;
    private Instant date;
    @NotNull
    private Long author;

}
