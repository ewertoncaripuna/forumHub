package br.com.alura.forum_Hub.domain.usuario;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DadosExclusaoUsuario(@NotBlank @Email String email, @NotBlank String senha) {
}
