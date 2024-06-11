package com.br.thiago.projeto_santander_2024.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.thiago.projeto_santander_2024.domain.model.User;

@Repository//nao é obrigatorio mas é uma boa pratica deixar uma anottation que é um repository
public interface UserRepository extends JpaRepository<User,Long> {//o JpaRepository usa generics para voce informar o tipo dele ( a Calsse
	// e qual o tipo do Id dessa Classe

	
	boolean existsByAccountNumber(String accountNumber);//criar um metodo que verifica se o usuario existe pelo numero da conta
	//esse metodo voce cria para validar a existencia do usuario, nao precisando implantar isso no service impl
	//userToCreate.getId()!= null && userRepository.existsById(userToCreate.getId())
	//se o id for diferente de null e o usuario ja existe

	boolean existsByCardNumber(String number);
}

	


