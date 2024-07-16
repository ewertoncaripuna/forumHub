package br.com.alura.forum_Hub.domain.resposta;


import br.com.alura.forum_Hub.domain.topico.Topico;
import br.com.alura.forum_Hub.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "respostas")
@Entity(name = "Resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Topico topico;

    private OffsetDateTime data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Resposta(Topico topico, Usuario usuario, DadosNovaResposta dados){
        this.mensagem = dados.mensagem();
        this.topico = topico;
        this.data = LocalDateTime.now().atOffset(ZoneOffset.of("-03:00"));
        this.usuario = usuario;
    }
}
