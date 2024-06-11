package com.br.thiago.projeto_santander_2024.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.thiago.projeto_santander_2024.domain.model.User;
import com.br.thiago.projeto_santander_2024.service.UserService;

@RestController//comentario do spring que a classe é um rest controller
@RequestMapping("/users")//adiciona um request para quando voce for acessar o site ele acione a classe ao chamar /users
public class UserController {

	private final UserService userService;//agora o controller vai implementar o service criado
	//note que podemos chamar a interface e a camada de negocio nao fica visivel para todos 
	
	public UserController(UserService userService) {
		this.userService = userService;//construtor que chama um userService
	}
	
	@GetMapping("/{id}")//informa que ira ser usado um metodo get que vai pegar um id
	public ResponseEntity<User> findById(@PathVariable Long id){//procura o usuario na lista pelo id,
		//o id informado é o informado no path acima
		var user = userService.findById(id);//pega o usuario e coloca
		return ResponseEntity.ok(user);//a validacao do usuario ja está no ServiceImpl
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User userToCreated){//pegar toda a requisicao do corpo da pagina
		var userCreated = userService.create(userToCreated);//pega o usuario e cria 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userCreated.getId())
				.toUri();//URI retorn a localizacao do atributo
		//fromCurrentRequest ajuda a cria a location colocando o path("/{id}")
		//retorna a url criada no id do usuario, no caso o @GetMapping("/{id}")
		//buildAndExpand(userCreated.getId()) atribui o valor para substituir o "/{id}" pelo valor especificamente
		//.toUri(); cria a location
		return ResponseEntity.created(location).body(userToCreated);
		//retorna o location e o usuario criado
	}
}
