package br.com.alura.forum_Hub.domain.controller;

import br.com.alura.forum_Hub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    GerenciarTopicos gerenciarTopicos;
    @Autowired
    TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criarTopico(@RequestBody @Valid DadosCadastroTopico dados){
        var topico = gerenciarTopicos.criarTopico(dados);
        return ResponseEntity.ok(topico);
    }
    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }
    @GetMapping
    public ResponseEntity listarTopicos(){
        var topicos = topicoRepository.findAll().stream()
                .map(DadosDetalhamentoTopico::new).collect(Collectors.toList());
        return ResponseEntity.ok(topicos);
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados){
        var topico = topicoRepository.getReferenceById(id);
        topico.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id, @RequestBody  @Valid DadosExclusaoTopico dados){
        gerenciarTopicos.excluir(dados, id);
        return ResponseEntity.noContent().build();
    }

}
