// Declaração do pacote onde a interface está localizada.
// Os pacotes ajudam a organizar as classes e interfaces em um projeto Java.
package com.br.thiago.projeto_santander_2024.service;

// Importação da classe List do pacote java.util.
// List é uma interface que representa uma coleção ordenada de elementos.
import java.util.List;

// Declaração da interface CrudService.
// Uma interface em Java é um contrato que define um conjunto de métodos que uma classe deve implementar.
public interface CrudService<ID, T> {

    // Declaração do método findAll.
    // Este método não recebe parâmetros e retorna uma lista de objetos do tipo T.
    // É usado para recuperar todos os registros da entidade gerenciada.
    List<T> findAll();

    // Declaração do método findById.
    // Este método recebe um parâmetro de tipo ID e retorna um objeto do tipo T.
    // É usado para recuperar um registro específico da entidade gerenciada pelo seu identificador.
    T findById(ID id);

    // Declaração do método create.
    // Este método recebe um parâmetro de tipo T e retorna um objeto do tipo T.
    // É usado para criar um novo registro da entidade gerenciada.
    T create(T entity);

    // Declaração do método update.
    // Este método recebe dois parâmetros: um de tipo ID e outro de tipo T, e retorna um objeto do tipo T.
    // É usado para atualizar um registro existente da entidade gerenciada pelo seu identificador.
    T update(ID id, T entity);

    // Declaração do método delete.
    // Este método recebe um parâmetro de tipo ID e não retorna nenhum valor (void).
    // É usado para deletar um registro da entidade gerenciada pelo seu identificador.
    void delete(ID id);
}

/*
 * 
 * public interface CrudService<ID, T> {

Descrição: Declara a interface CrudService com dois parâmetros genéricos: ID e T.
Propósito: Define um contrato que outras classes devem seguir ao implementar operações CRUD (Create, Read, Update, Delete) para qualquer tipo de entidade (T) e identificador (ID).
List<T> findAll();

Descrição: Declara um método que retorna uma lista de objetos do tipo T.
Propósito: Recuperar todos os registros da entidade gerenciada. Este método é usado para listar todos os objetos de uma entidade.
T findById(ID id);

Descrição: Declara um método que recebe um identificador do tipo ID e retorna um objeto do tipo T.
Propósito: Recuperar um registro específico da entidade pelo seu identificador. Este método é usado para obter os detalhes de um objeto específico.
T create(T entity);

Descrição: Declara um método que recebe um objeto do tipo T e retorna um objeto do tipo T.
Propósito: Criar um novo registro da entidade gerenciada. Este método é usado para adicionar um novo objeto à coleção de entidades.
T update(ID id, T entity);

Descrição: Declara um método que recebe um identificador do tipo ID e um objeto do tipo T, e retorna um objeto do tipo T.
Propósito: Atualizar um registro existente da entidade pelo seu identificador. Este método é usado para modificar os dados de um objeto existente.
void delete(ID id);

Descrição: Declara um método que recebe um identificador do tipo ID e não retorna nenhum valor.
Propósito: Deletar um registro da entidade pelo seu identificador. Este método é usado para remover um objeto da coleção de entidades.
Propósito Geral da Interface CrudService
A interface CrudService é um contrato genérico que define métodos básicos de CRUD para qualquer tipo de entidade (T) e identificador (ID). A ideia por trás dessa interface é padronizar as operações CRUD, de modo que diferentes entidades possam implementar essas operações de maneira consistente.

Essa interface genérica permite que você defina um conjunto de operações básicas que qualquer serviço de entidade deve fornecer. Por exemplo, você pode ter um UserService que implementa CrudService<Long, User>, significando que UserService gerencia entidades User com identificadores do tipo Long.

Benefícios de Usar Interfaces Genéricas
Reutilização de Código: Você pode reutilizar a mesma interface para diferentes tipos de entidades, evitando a duplicação de código.
Consistência: Todas as entidades terão um conjunto consistente de operações CRUD, facilitando a manutenção e a compreensão do código.
Flexibilidade: Você pode usar qualquer tipo para os identificadores e as entidades, tornando a interface CrudService altamente flexível.
Facilita Testes: A padronização das operações CRUD facilita a criação de testes unitários e de integração.
 * 
 * 
 * 
 * */
