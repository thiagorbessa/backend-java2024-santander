package com.br.thiago.projeto_santander_2024.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name= "tb_user")//definir que essa classe referencia a tabela no banco de dados com nome tb_user
public class User {
	
	@Id//diz que o id é o id do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //diz que o valor será automaticamente com estrategia identity
	private Long id;
	
	@Column(length = 100)//define que o tamanho nao pode passar de 100 caracteres
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)//relacionamento de User com Account 1 para 1 
	private Account account;//Cascate garante que o ralacionamento muito forte entre elas quando um usuario for deletado sua conta tambem será
	
	@OneToOne(cascade = CascadeType.ALL)//garante tambem a informacao de chave estrangeira
	private Card card;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//relacionamento de User com fEATURE 1 para MUITOS
	private List<Feature> feature;//fetch toda vez que o usuario for buscado no banco ele informa a lista de feature
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<News> news;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public List<Feature> getFeature() {
		return feature;
	}
	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	
	

}
