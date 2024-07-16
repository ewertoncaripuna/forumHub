package br.com.alura.forum_Hub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosLogin(@Email @NotBlank String email, @NotBlank String senha) {
}
