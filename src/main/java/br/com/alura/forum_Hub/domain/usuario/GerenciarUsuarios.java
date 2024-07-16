package br.com.alura.forum_Hub.domain.usuario;

import br.com.alura.forum_Hub.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GerenciarUsuarios {

    @Autowired
    UsuarioRepository usuarioRepository;


    public void excluir(Long id, DadosExclusaoUsuario dados){

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isEmpty()){
            throw new ValidacaoException("Nenhum usuário encontrado com o id informado.");
        }

        if(!usuario.get().getSenha().equals(dados.senha()) && !usuario.get().getEmail().equals(dados.email()) ){
            throw new ValidacaoException("Não é possível excluir o usuário de outra conta");
        }

        usuario.get().excluir();

    }

}
