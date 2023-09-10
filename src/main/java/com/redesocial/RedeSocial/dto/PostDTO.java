package com.redesocial.RedeSocial.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.redesocial.RedeSocial.domain.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Serializable {

    @NotNull
    private Long id;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;
    @NotNull
    private String title;
    @NotNull
    private String body;
    @NotNull
    private Long author;
}
