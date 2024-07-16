package br.com.alura.forum_Hub.domain.resposta;

import br.com.alura.forum_Hub.domain.usuario.DadosDetalhamentoUsuario;

import java.time.OffsetDateTime;

public record DadosDetalhamentoResposta(Long id, String mensagem, Long topico_id, OffsetDateTime data, DadosDetalhamentoUsuario usuario) {

    public DadosDetalhamentoResposta(Resposta resposta){
        this(resposta.getId(), resposta.getMensagem(), resposta.getTopico().getId(), resposta.getData(), new DadosDetalhamentoUsuario(resposta.getUsuario()));
    }

}
