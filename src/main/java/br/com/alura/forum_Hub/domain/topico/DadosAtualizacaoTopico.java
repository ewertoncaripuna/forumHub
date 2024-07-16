package br.com.alura.forum_Hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(

        @NotNull
        Long usuario_id,
        @NotBlank
        String senha,

        @NotNull
        Long id,

        String titulo,

        String mensagem,

        Status status,

        Long curso_id
) {
}
