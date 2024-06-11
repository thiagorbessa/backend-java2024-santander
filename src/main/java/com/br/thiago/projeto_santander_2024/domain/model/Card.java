package com.br.thiago.projeto_santander_2024.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_card")//definir que essa classe referencia a tabela no banco de dados com nome tb_account
public class Card {
	
	@Id//diz que o id é o id do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //diz que o valor será automaticamente com estrategia identity
	private Long id;
	
	@Column(unique = true)//diz que o number nao pode ter nenhum valor igual em nenhuma outra account
	private String number;
	
	@Column(name ="available_limit",precision = 13,scale=2)//name ="available_limit" é o nome que o limit vai ser no banco de dados
	private BigDecimal limit;//define a quantidade de inteiros e de numeros atras da virgula precision = inteiros scale = numeros apos a virgula
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	
	
}
