package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.Infrastructure.repository.UserRepository;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.entities.User;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Implementação do serviço de usuários.
 *
 * Esta classe fornece a implementação dos métodos definidos na interface UserServiceInterface,
 * lidando com a lógica de negócios relacionada aos usuários, como criar e atualizar usuários.
 */
@Service
public class UserServiceImpl implements UserServiceInterface {

    // Repositório para a persistência de dados de usuários.
    private final UserRepository userRepository;
    private final ParameterNamesModule parameterNamesModule;


    /**
     * Construtor para injeção de dependência do UserRepository.
     *
     * @param userRepository O repositório de usuários a ser injetado.
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository, ParameterNamesModule parameterNamesModule) {
        this.userRepository = userRepository;
        this.parameterNamesModule = parameterNamesModule;
    }

    /**
     * Salva um novo usuário ou atualiza um usuário existente.
     * <p>
     * Cria uma nova entidade User a partir dos dados fornecidos no UserRequestDto, persiste essa
     * entidade no banco de dados, e retorna um UserResponseDto com as informações do usuário salvo.
     *
     * @param userRequestDto DTO contendo os dados do usuário a ser salvo ou atualizado.
     * @return DTO com as informações do usuário salvo, incluindo o ID gerado e o nome.
     */
    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        // Cria uma nova instância de User.
        User user = new User();
        // Define o nome do usuário a partir do DTO.
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setCpf(userRequestDto.getCpf());
        user.setCnpj(userRequestDto.getCnpj());
        user.setIsActive(userRequestDto.getIs_active());

        // Salva o usuário no banco de dados e obtém a entidade persistida com o ID gerado.
        User savedUser = userRepository.save(user);

        // Cria um DTO de resposta com as informações do usuário salvo.
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(savedUser.getId());
        userResponseDto.setName(savedUser.getName());
        userResponseDto.setEmail(savedUser.getEmail());
        userResponseDto.setPassword(savedUser.getPassword());
        userResponseDto.setCpf(savedUser.getCpf());
        userResponseDto.setCnpj(savedUser.getCnpj());
        userResponseDto.setIs_active(savedUser.getIsActive());


        // Retorna o DTO com as informações do usuário salvo.
        return userResponseDto;
    }

    @Override
    public UserResponseDto update(UserRequestDto userRequestDto, Long id) {
        User userExist = userRepository.findById(id).orElseThrow();

        userExist.setName(userRequestDto.getName());
        userExist.setEmail(userRequestDto.getEmail());
        userExist.setPassword(userRequestDto.getPassword());
        userExist.setCpf(userRequestDto.getCpf());
        userExist.setCnpj(userRequestDto.getCnpj());
        userExist.setIsActive(userRequestDto.getIs_active());
        userRepository.save(userExist);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(userExist.getId());
        userResponseDto.setName(userExist.getName());
        userResponseDto.setEmail(userExist.getEmail());
        userResponseDto.setPassword(userExist.getPassword());
        userResponseDto.setCpf(userExist.getCpf());
        userResponseDto.setCnpj(userExist.getCnpj());
        userResponseDto.setIs_active(userExist.getIsActive());

        return userResponseDto;
    }

    @Override
    public User findById(Long userId) {
        return null;
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User buscarPorId(Long id) {
        return userRepository.findById(id).orElseThrow(
        );
    }

    @Transactional
    public User ativarUsuario(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado"));
        user.setIsActive(true);
        return userRepository.save(user);
    }

    @Transactional
    public User desativarUsuario(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado"));
        user.setIsActive(false);
        return userRepository.save(user);
    }

}
