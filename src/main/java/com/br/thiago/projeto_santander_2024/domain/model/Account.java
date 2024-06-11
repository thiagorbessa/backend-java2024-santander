package com.br.thiago.projeto_santander_2024.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_account")//definir que essa classe referencia a tabela no banco de dados com nome tb_account
public class Account {
	@Id//diz que o id é o id do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //diz que o valor será automaticamente com estrategia identity
	private Long id;
	
	@Column(unique = true)//diz que o number nao pode ter nenhum valor igual em nenhuma outra account
	private String number;//@Column(nullable = false)nullable = falso diz que nao pode ter nulo ao criar
	
	
	private String agency;
	
	@Column(precision = 13,scale=2)//define a quantidade de inteiros e de numeros atras da virgula precision = inteiros scale = numeros apos a virgula
	private BigDecimal balance;
	
	@Column(name ="additional_limit",precision = 13,scale=2)//name ="additional_limit" é o nome que o limit vai ser no banco de dados
	private BigDecimal limit;
	
	
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
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balace) {
		this.balance = balace;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	
	

}
