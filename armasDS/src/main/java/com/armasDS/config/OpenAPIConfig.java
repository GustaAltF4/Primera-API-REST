package com.armasDS.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "SoulsArmoryAPI",
                version = "1.0.0",
                description = "Armas y Escudos de Dark Souls"
        )
)
public class OpenAPIConfig {

        @Bean
        public GroupedOpenApi api() {
            return GroupedOpenApi.builder()
                    .group("Arma Aleatoria")
                    .pathsToMatch("/api/weaponsDS/**")
                    .build();
        }
        @Bean
        public GroupedOpenApi api2() {
                return GroupedOpenApi.builder()
                        .group("Obtener Arma Especifica")
                        .pathsToMatch("/api/weaponsDS/**")
                        .build();
        }
        @Bean
        public GroupedOpenApi api3() {
                return GroupedOpenApi.builder()
                        .group("Obtener Arma Especifica Resumida")
                        .pathsToMatch("/api/weaponsDS/**")
                        .build();
        }
        @Bean
        public GroupedOpenApi api4() {
                return GroupedOpenApi.builder()
                        .group("Obtener Grupos de Armas")
                        .pathsToMatch("/api/weaponsDS/**")
                        .build();
        }
        @Bean
        public GroupedOpenApi api5() {
                return GroupedOpenApi.builder()
                        .group("Acciones de Modificación")
                        .pathsToMatch("/api/weaponsDS/**")
                        .build();
        }


}

