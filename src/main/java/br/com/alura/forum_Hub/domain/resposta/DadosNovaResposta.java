package br.com.alura.forum_Hub.domain.resposta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosNovaResposta(
        @NotBlank
        String mensagem,
        @NotNull
        Long topico_id,
        @NotNull
        Long usuario_id
        ) {
}
