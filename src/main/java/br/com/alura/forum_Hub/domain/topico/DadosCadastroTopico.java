package br.com.alura.forum_Hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        Status status,
        @NotNull
        Long curso_id,
        @NotNull
        Long usuario_id) {
}
