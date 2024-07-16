package br.com.alura.forum_Hub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))).info(new Info()
                        .title("Fórum.hub API")
                        .description(
                                "Projeto final de conclusão do curso/bootcamp da Alura em parceria com a Oracle. Formação " +
                                " em Java Spring boot" +
                                "Aplicação básica de um fórum, com tópicos, respostas e perfis. Features como autênticação, " +
                                " boas práticas e uso de libs mais recentes e usadas do mercado estão no projeto. " +
                                "Sendo possível, visualizar, atualizar e deletar tópicos de discussão, perfis, respostas, " +
                                "cursos e usuários. Onde somente usuários autenticados podem " +
                                "interagir."));
    }

}
