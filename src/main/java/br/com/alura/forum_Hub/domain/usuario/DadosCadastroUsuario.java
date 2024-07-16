package br.com.alura.forum_Hub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;


public record DadosCadastroUsuario(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha

) {
}
