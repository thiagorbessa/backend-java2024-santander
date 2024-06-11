// Define o pacote onde a classe está localizada
package com.br.thiago.projeto_santander_2024.controller.dto;

// Importa a classe News do pacote especificado
import com.br.thiago.projeto_santander_2024.domain.model.News;

// Define um record chamado `NewsDto` com três campos: id, icon, e description
public record NewsDto(Long id, String icon, String description) {

    // Construtor que aceita um objeto `News` e inicializa o record `NewsDto` com os valores dos campos do `News`
    public NewsDto(News model) {
        // Chama o construtor principal do record com os valores extraídos do objeto `News`
        this(model.getId(), model.getIcon(), model.getDescription());
    }

    // Método para converter o `NewsDto` de volta para um objeto `News`
    public News toModel() {
        // Cria uma nova instância de `News`
        News model = new News();
        // Define os campos da instância `News` com os valores do record `NewsDto`
        model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.description);
        // Retorna a instância `News` preenchida
        return model;
    }
}