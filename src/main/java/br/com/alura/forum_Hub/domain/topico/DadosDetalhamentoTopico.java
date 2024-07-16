package br.com.alura.forum_Hub.domain.topico;

import br.com.alura.forum_Hub.domain.resposta.DadosDetalhamentoResposta;
import br.com.alura.forum_Hub.domain.usuario.DadosDetalhamentoUsuario;
import br.com.alura.forum_Hub.domain.curso.DadosDetalhamentoCurso;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalhamentoTopico (Long id,
                                       String titulo,
                                       String mensagem,
                                       OffsetDateTime data,
                                       Status status,
                                       DadosDetalhamentoUsuario autor,
                                       DadosDetalhamentoCurso curso,
                                       List<DadosDetalhamentoResposta> respostas) {

    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(),new DadosDetalhamentoUsuario(topico.getUsuario()), new DadosDetalhamentoCurso(topico.getCurso()),
        topico.getRespostas().stream()
        .map(d -> new DadosDetalhamentoResposta(d.getId(), d.getMensagem(), d.getTopico().getId(),
        d.getData(), new DadosDetalhamentoUsuario(d.getUsuario()) )).collect(Collectors.toList()));
    }

}
