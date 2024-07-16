package br.com.alura.forum_Hub.domain.topico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosExclusaoTopico (
        @NotBlank @Email String email,
        @NotBlank String senha) {
}
