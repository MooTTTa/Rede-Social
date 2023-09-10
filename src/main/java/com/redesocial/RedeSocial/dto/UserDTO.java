package com.redesocial.RedeSocial.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;

}
