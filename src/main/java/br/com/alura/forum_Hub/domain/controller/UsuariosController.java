package br.com.alura.forum_Hub.domain.controller;

import br.com.alura.forum_Hub.domain.usuario.DadosDetalhamentoUsuario;
import br.com.alura.forum_Hub.domain.usuario.DadosExclusaoUsuario;
import br.com.alura.forum_Hub.domain.usuario.GerenciarUsuarios;
import br.com.alura.forum_Hub.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuariosController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    GerenciarUsuarios gerenciarUsuarios;

    @GetMapping
    public ResponseEntity listarUsuarios(){
        List<DadosDetalhamentoUsuario> usuarios = usuarioRepository.findAllByAtivoTrue()
                .stream().map(DadosDetalhamentoUsuario::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirUsuario(@PathVariable Long id, @RequestBody @Valid DadosExclusaoUsuario dados){
        gerenciarUsuarios.excluir(id, dados);
        return ResponseEntity.noContent().build();
    }


}
