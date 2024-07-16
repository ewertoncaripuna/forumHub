package br.com.alura.forum_Hub.domain.controller;

import br.com.alura.forum_Hub.domain.curso.CursoRepository;
import br.com.alura.forum_Hub.domain.curso.DadosDetalhamentoCurso;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity listarCursos(){
        List <DadosDetalhamentoCurso> cursos = cursoRepository.findAll().stream()
                .map(c -> new DadosDetalhamentoCurso(c))
                .collect(Collectors.toList());
        System.out.println(cursos);
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharCurso(@PathVariable Long id){
        var curso = cursoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }

}
