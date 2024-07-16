package br.com.alura.forum_Hub.domain.resposta;

import br.com.alura.forum_Hub.domain.topico.TopicoRepository;
import br.com.alura.forum_Hub.domain.usuario.UsuarioRepository;
import br.com.alura.forum_Hub.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GerenciarRespostas {

    @Autowired
    RespostaRepository respostaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    public DadosDetalhamentoResposta criarResposta (DadosNovaResposta dados){

        if(!topicoRepository.existsById(dados.topico_id())){
            throw new ValidacaoException("O tópico informado não existe!");
        }
        if(!usuarioRepository.existsById(dados.usuario_id())){
            throw new ValidacaoException("O usuário informado não existe!");
        }

        var usuario = usuarioRepository.getReferenceById(dados.usuario_id());
        var topico = topicoRepository.getReferenceById(dados.topico_id());

        var resposta = new Resposta(topico, usuario, dados);

        respostaRepository.save(resposta);
        return new DadosDetalhamentoResposta(resposta);
    }

    public String excluir (DadosExclusaoResposta dados, Long id){
        Optional<Resposta> resposta = respostaRepository.findById(id);
        if(resposta.isEmpty()){
            throw new ValidacaoException("Resposta não existe.");
        }
        if(!resposta.get().getUsuario().getEmail().equals(dados.email()) && !resposta.get().getTopico().getUsuario().getEmail().equals(dados.senha())){
            throw new ValidacaoException("ESta resposta não é de sua autoria.");
        }

        respostaRepository.delete(resposta.get());

        return "Resposta: " + resposta.get() + " excluida com sucesso."  ;
    }


}
