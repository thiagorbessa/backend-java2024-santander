package com.br.thiago.projeto_santander_2024.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // anotacao do spring que identifica um bind nessa classe
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	// A linha acima declara uma variável final chamada 'logger' do tipo Logger.
	// O 'Logger' é uma interface fornecida pela biblioteca SLF4J (Simple Logging Facade for Java), que é uma API de logging.
	// 'LoggerFactory' é uma classe fornecida pelo SLF4J para criar instâncias de 'Logger'.
	// 'getLogger(GlobalExceptionHandler.class)' cria um logger associado à classe 'GlobalExceptionHandler'.
	// Isso significa que todas as mensagens de log registradas por esta instância de 'logger' serão associadas a 'GlobalExceptionHandler'.
	// O logger é usado para registrar mensagens de log em diferentes níveis (info, debug, error, etc.), que ajudam no rastreamento e depuração da aplicação.
	
	//podemos comecar criando o metodo so com o nome de handle depois escolhemos o melhor nome do metodo, nesse caso handleBusinessException
	@ExceptionHandler(IllegalArgumentException.class) //informa para o spring que o metodo abaixo vai tratar o erro de IllegalArgumentException 
	public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException){//vamos tratar a classe 
		//que está no metodo created na classe UserServiceImpl
		return new ResponseEntity<>(businessException.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);//retorn a mensagem que ja cadastramos tambem o erro no http
		// 422 Unprocessable Entity.
	}
	
	//podemos comecar criando o metodo so com o nome de handle depois escolhemos o melhor nome do metodo, nesse caso handleNoFoundException
	@ExceptionHandler(NoSuchElementException.class) //informa para o spring que o metodo abaixo vai tratar o erro de NoSuchElementException 
	public ResponseEntity<String> handleNoFoundException(NoSuchElementException noFoundException){//vamos tratar a classe 
		//que está no metodo findById na classe UserServiceImpl
		return new ResponseEntity<>("Resource ID not found",HttpStatus.NOT_FOUND);//retorna a mensagem que ja cadastramos tambem o erro no http
		//nesse caso o erro cadastrado é NOT_FOUND 404 Not Found.
		// se não tiver nenhuma mensagem já cadastrada como o caso da IllegalArgumentException
		//podemos colocar a mensagem direto no ResponseEntity que ela vai aparecer no body
	}
	
	@ExceptionHandler(Throwable.class)//informa para o spring que o metodo abaixo vai tratar o erro de Throwable esse é obrigatorio pois é o erro mais genérico que se trata e deve ser informado para haver tratemento por mais simples que seja 
	public ResponseEntity<String> handleUnexpectException(Throwable unexpectException){
		//esse erro é o geral que fica na classe do java Throwable
		
		var mensage = "unexpect server  error, see the logs";//texto com a mensagem de erro
		//o uso do var no java 17 deixa voce usar uma variavel sem precisar ficar tipando ela quando o tipo ja é
		// implicito
		
		logger.error(mensage,unexpectException);//vai fazer o log do erro dessa excecao
		
		/*
		 * registra uma mensagem de erro, incluindo a stack trace do unexpectException.
		 *  Mesmo que a mensagem de erro seja uma string vazia, 
		 *  o logger ainda registrará a mensagem da exceção e a stack trace. 
		 *  nesse caso adicionamos a variavel mensage que vai retornar uma mensagem 
		 *  "unexpect server  error, see the logs"
		 *  Isso é extremamente útil para identificar onde e por que uma exceção ocorreu.
		 * 
		 * */
		
		return new ResponseEntity<>(mensage,HttpStatus.INTERNAL_SERVER_ERROR);
		//nesse caso o erro cadastrado é 500 Internal Server Error.
		//podemos colocar a mensagem direto no ResponseEntity que ela vai aparecer no body que houve um erro inexperado no servidor
		
	}
}
