package com.br.thiago.projeto_santander_2024.controller.dto;
//Define o pacote onde a classe está localizada

import java.math.BigDecimal;

import com.br.thiago.projeto_santander_2024.domain.model.Card;




//Importa a classe BigDecimal para manipulação de números decimais
import java.math.BigDecimal;

//Importa a classe Card do pacote especificado
import com.br.thiago.projeto_santander_2024.domain.model.Card;

//Define um record chamado `CardDto` com três campos: id, number, e limit
public record CardDto(Long id, String number, BigDecimal limit) {

 // Construtor que aceita um objeto `Card` e inicializa o record `CardDto` com os valores dos campos do `Card`
 public CardDto(Card model) {
     // Chama o construtor principal do record com os valores extraídos do objeto `Card`
     this(model.getId(), model.getNumber(), model.getLimit());
 }

 // Método para converter o `CardDto` de volta para um objeto `Card`
 public Card toModel() {
     // Cria uma nova instância de `Card`
     Card model = new Card();
     // Define os campos da instância `Card` com os valores do record `CardDto`
     model.setId(this.id);
     model.setNumber(this.number);
     model.setLimit(this.limit);
     // Retorna a instância `Card` preenchida
     return model;
 }
}
