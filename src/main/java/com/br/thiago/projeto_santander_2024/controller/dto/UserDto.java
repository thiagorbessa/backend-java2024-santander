// Define o pacote onde a classe está localizada
package com.br.thiago.projeto_santander_2024.controller.dto;

// Importa a classe List para manipulação de listas
import java.util.List;

// Importa a classe User do pacote especificado
import com.br.thiago.projeto_santander_2024.domain.model.User;

// Importa métodos estáticos de coleções e opções
import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

// Define um record chamado `UserDto` com seis campos: id, name, account, card, features, e news
public record UserDto(
        Long id,
        String name,
        AccountDto account,
        CardDto card,
        List<FeatureDto> features,
        List<NewsDto> news) {

    // Construtor que aceita um objeto `User` e inicializa o record `UserDto` com os valores dos campos do `User`
    public UserDto(User model) {
        // Chama o construtor principal do record com os valores extraídos do objeto `User`
        this(
                model.getId(), // Inicializa o campo id com o valor do campo id do objeto `User`
                model.getName(), // Inicializa o campo name com o valor do campo name do objeto `User`
                ofNullable(model.getAccount()).map(AccountDto::new).orElse(null), // Inicializa o campo account com um novo `AccountDto` ou null se a conta for null
                ofNullable(model.getCard()).map(CardDto::new).orElse(null), // Inicializa o campo card com um novo `CardDto` ou null se o cartão for null
                ofNullable(model.getFeature()).orElse(emptyList()).stream().map(FeatureDto::new).collect(toList()), // Inicializa o campo features com uma lista de `FeatureDto` ou uma lista vazia se for null
                ofNullable(model.getNews()).orElse(emptyList()).stream().map(NewsDto::new).collect(toList()) // Inicializa o campo news com uma lista de `NewsDto` ou uma lista vazia se for null
        );
    }

    // Método para converter o `UserDto` de volta para um objeto `User`
    public User toModel() {
        // Cria uma nova instância de `User`
        User model = new User();
        // Define os campos da instância `User` com os valores do record `UserDto`
        model.setId(this.id);
        model.setName(this.name);
        model.setAccount(ofNullable(this.account).map(AccountDto::toModel).orElse(null));
        model.setCard(ofNullable(this.card).map(CardDto::toModel).orElse(null));
        model.setFeature(ofNullable(this.features).orElse(emptyList()).stream().map(FeatureDto::toModel).collect(toList()));
        model.setNews(ofNullable(this.news).orElse(emptyList()).stream().map(NewsDto::toModel).collect(toList()));
        // Retorna a instância `User` preenchida
        return model;
    }

}