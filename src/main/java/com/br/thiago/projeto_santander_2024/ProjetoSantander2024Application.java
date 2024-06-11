package com.br.thiago.projeto_santander_2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = { @Server(url = "/",description = "Default server URL")}) // aponta para o contexto que o swagger esta rodando
@SpringBootApplication
public class ProjetoSantander2024Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSantander2024Application.class, args);
	}

}
