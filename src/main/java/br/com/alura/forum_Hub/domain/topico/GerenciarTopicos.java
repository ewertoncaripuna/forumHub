package br.com.alura.forum_Hub.domain.topico;

import br.com.alura.forum_Hub.domain.usuario.UsuarioRepository;
import br.com.alura.forum_Hub.domain.curso.CursoRepository;
import br.com.alura.forum_Hub.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GerenciarTopicos {

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TopicoRepository topicoRepository;

    public DadosDetalhamentoTopico criarTopico(DadosCadastroTopico dados){
        if(!cursoRepository.existsById(dados.curso_id())){
            throw new ValidacaoException("Curso não existe no sistema!");
        }
        if(!usuarioRepository.existsById(dados.usuario_id())){
            throw new ValidacaoException("Usuario não existe!");
        }
        var usuario = usuarioRepository.getReferenceById(dados.usuario_id());
        var curso = cursoRepository.getReferenceById(dados.curso_id());
        var topico = new Topico(usuario, curso, dados);

        topicoRepository.save(topico);
        return new DadosDetalhamentoTopico(topico);
    }

    public String excluir(DadosExclusaoTopico dados, Long id){

        Optional<Topico> topico = topicoRepository.findById(id);

        if(topico.isEmpty()){
            throw new ValidacaoException("Nenhum tópico encontrado com o id informado.");
        }
        if(!(topico.get().getUsuario().getEmail().equals(dados.email())) && !topico.get().getUsuario().getSenha().equals(dados.senha())) {
            throw new ValidacaoException("Você não é responsável por este tópico");
        }else{
            topicoRepository.delete(topico.get());
            return "Tópico "+ topico.get() + " excluído!";
        }

    }

}
