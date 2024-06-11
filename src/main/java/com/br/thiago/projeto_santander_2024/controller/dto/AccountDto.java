package com.br.thiago.projeto_santander_2024.controller.dto;

import java.math.BigDecimal;

import com.br.thiago.projeto_santander_2024.domain.model.Account;

//Define uma classe `AccountDto` como um record, que é uma forma concisa de criar classes imutáveis em Java.
//A classe tem cinco campos: id, number, agency, balance e limit.
public record AccountDto(Long id, String number, String agency, BigDecimal balance, BigDecimal limit) {

 // Construtor que aceita um objeto `Account` e inicializa o record `AccountDto` com os valores dos campos do `Account`.
 public AccountDto(Account model) {
     // Chama o construtor principal do record com os valores extraídos do objeto `Account`.
     this(model.getId(), model.getNumber(), model.getAgency(), model.getBalance(), model.getLimit());
 }

 // Método para converter o `AccountDto` de volta para um objeto `Account`.
 public Account toModel() {
     // Cria uma nova instância de `Account`.
     Account model = new Account();
     // Define os campos da instância `Account` com os valores do record `AccountDto`.
     model.setId(this.id);
     model.setNumber(this.number);
     model.setAgency(this.agency);
     model.setBalance(this.balance);
     model.setLimit(this.limit);
     // Retorna a instância `Account` preenchida.
     return model;
 }
}
