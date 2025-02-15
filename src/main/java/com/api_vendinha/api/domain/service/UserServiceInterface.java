package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.entities.User;

/**
 * Interface que define os serviços relacionados a usuários.
 *
 * Esta interface fornece um contrato para a implementação dos serviços de usuários,
 * especificando os métodos que devem ser fornecidos pelas classes que a implementam.
 */
public interface UserServiceInterface {

    /**
     * Salva um novo usuário ou atualiza um usuário existente.
     *
     * @param userRequestDto DTO que contém os dados do usuário a ser salvo ou atualizado.
     * @return DTO com as informações do usuário salvo, incluindo o ID gerado e outros detalhes.
     */
    UserResponseDto save(UserRequestDto userRequestDto);
    UserResponseDto update(UserRequestDto userRequestDto, Long id);
    User findById(Long userId);
    void delete(Long id);
    User buscarPorId(Long id);
    User ativarUsuario(Long id);
    User desativarUsuario(Long id);
}
