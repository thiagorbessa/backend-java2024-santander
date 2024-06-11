// Define o pacote onde a classe está localizada
package com.br.thiago.projeto_santander_2024.controller.dto;

// Importa a classe Feature do pacote especificado
import com.br.thiago.projeto_santander_2024.domain.model.Feature;

// Define um record chamado `FeatureDto` com três campos: id, icon, e description
public record FeatureDto(Long id, String icon, String description) {

    // Construtor que aceita um objeto `Feature` e inicializa o record `FeatureDto` com os valores dos campos do `Feature`
    public FeatureDto(Feature model) {
        // Chama o construtor principal do record com os valores extraídos do objeto `Feature`
        this(model.getId(), model.getIcon(), model.getDescription());
    }

    // Método para converter o `FeatureDto` de volta para um objeto `Feature`
    public Feature toModel() {
        // Cria uma nova instância de `Feature`
        Feature model = new Feature();
        // Define os campos da instância `Feature` com os valores do record `FeatureDto`
        model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.description);
        // Retorna a instância `Feature` preenchida
        return model;
    }
}