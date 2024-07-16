package br.com.alura.forum_Hub.domain.resposta;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosExclusaoResposta (
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
