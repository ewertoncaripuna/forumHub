package br.com.alura.forum_Hub.domain.controller;

import br.com.alura.forum_Hub.domain.resposta.DadosNovaResposta;
import br.com.alura.forum_Hub.domain.resposta.DadosExclusaoResposta;
import br.com.alura.forum_Hub.domain.resposta.GerenciarRespostas;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {

    @Autowired
    GerenciarRespostas gerenciarRespostas;

    @PostMapping
    @Transactional
    public ResponseEntity criarResposta (@RequestBody @Valid DadosNovaResposta dados){
        var resposta = gerenciarRespostas.criarResposta(dados);
        return  ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirResposta(@PathVariable Long id, @RequestBody @Valid DadosExclusaoResposta dados){
        gerenciarRespostas.excluir(dados, id);
        return ResponseEntity.noContent().build();
    }

}
