package com.br.thiago.projeto_santander_2024.service.impl;

// Importa a classe List do pacote java.util.
// List é uma interface que representa uma coleção ordenada de elementos.
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.thiago.projeto_santander_2024.domain.model.User;
import com.br.thiago.projeto_santander_2024.domain.repository.UserRepository;
import com.br.thiago.projeto_santander_2024.service.UserService;
import com.br.thiago.projeto_santander_2024.service.exception.BusinessException;
import com.br.thiago.projeto_santander_2024.service.exception.NotFoundException;

// Importa o método estático ofNullable da classe Optional.
// ofNullable é usado para criar uma instância de Optional que pode ou não conter um valor.
import static java.util.Optional.ofNullable;

// Declaração da classe UserServiceImpl com a anotação @Service.
// @Service indica que esta classe é um componente de serviço do Spring.
@Service
public class UserServiceImpl implements UserService {

    // Declaração de uma constante que representa o ID de usuário que não pode ser alterado.
    // Este ID é utilizado em regras específicas de negócio.
    private static final Long UNCHANGEABLE_USER_ID = 1L;

    // Declaração de uma variável final para o repositório de usuários.
    // O repositório é usado para realizar operações de persistência no banco de dados.
    private final UserRepository userRepository;

    // Construtor da classe que inicializa o repositório de usuários.
    // Utiliza injeção de dependência para fornecer uma instância do UserRepository.
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método para encontrar todos os usuários.
    // @Transactional(readOnly = true) indica que a transação é apenas de leitura.
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    // Método para encontrar um usuário pelo seu ID.
    // @Transactional(readOnly = true) indica que a transação é apenas de leitura.
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    // Método para criar um novo usuário.
    // @Transactional indica que a operação é realizada dentro de uma transação.
    @Transactional
    public User create(User userToCreate) {
        // Validações para garantir que o usuário, a conta e o cartão não sejam nulos.
        ofNullable(userToCreate).orElseThrow(() -> new BusinessException("User to create must not be null."));
        ofNullable(userToCreate.getAccount()).orElseThrow(() -> new BusinessException("User account must not be null."));
        ofNullable(userToCreate.getCard()).orElseThrow(() -> new BusinessException("User card must not be null."));

        // Valida se o ID do usuário pode ser alterado.
        this.validateChangeableId(userToCreate.getId(), "created");

        // Verifica se o número da conta já existe no repositório.
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new BusinessException("This account number already exists.");
        }

        // Verifica se o número do cartão já existe no repositório.
        if (userRepository.existsByCardNumber(userToCreate.getCard().getNumber())) {
            throw new BusinessException("This card number already exists.");
        }

        // Salva o novo usuário no repositório e retorna o usuário salvo.
        return this.userRepository.save(userToCreate);
    }

    // Método para atualizar um usuário existente.
    // @Transactional indica que a operação é realizada dentro de uma transação.
    @Transactional
    public User update(Long id, User userToUpdate) {
        // Valida se o ID do usuário pode ser alterado.
        this.validateChangeableId(id, "updated");

        // Encontra o usuário existente no banco de dados pelo ID.
        User dbUser = this.findById(id);

        // Verifica se o ID do usuário a ser atualizado corresponde ao ID do usuário encontrado.
        if (!dbUser.getId().equals(userToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        // Atualiza os campos do usuário com os novos valores.
        dbUser.setName(userToUpdate.getName());
        dbUser.setAccount(userToUpdate.getAccount());
        dbUser.setCard(userToUpdate.getCard());
        dbUser.setFeature(userToUpdate.getFeature());
        dbUser.setNews(userToUpdate.getNews());

        // Salva o usuário atualizado no repositório e retorna o usuário salvo.
        return this.userRepository.save(dbUser);
    }

    // Método para deletar um usuário pelo seu ID.
    // @Transactional indica que a operação é realizada dentro de uma transação.
    @Transactional
    public void delete(Long id) {
        // Valida se o ID do usuário pode ser alterado.
        this.validateChangeableId(id, "deleted");

        // Encontra o usuário existente no banco de dados pelo ID.
        User dbUser = this.findById(id);

        // Deleta o usuário encontrado do repositório.
        this.userRepository.delete(dbUser);
    }

    // Método privado para validar se o ID do usuário pode ser alterado.
    // Recebe o ID do usuário e a operação que está sendo realizada.
    private void validateChangeableId(Long id, String operation) {
        // Verifica se o ID é igual ao ID do usuário que não pode ser alterado.
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            // Lança uma exceção se o ID não pode ser alterado.
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }
 }