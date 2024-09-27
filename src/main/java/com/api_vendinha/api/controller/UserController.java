package com.api_vendinha.api.controller;

import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.entities.User;
import com.api_vendinha.api.domain.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Controlador REST para gerenciar operações relacionadas aos usuários.
 */
@RestController
@RequestMapping("/api/users") // Define o caminho base para as requisições deste controlador.
public class UserController {

    // Injeção de dependência do serviço de usuários.
    private final UserServiceInterface userService;

    /**
     * Construtor para injeção de dependência do serviço de usuários.
     *
     * @param userService O serviço de usuários a ser injetado.
     */
    @Autowired
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    /**
     * Método para salvar um novo usuário.
     *
     * @param userRequestDto DTO que contém os dados do usuário a ser salvo.
     * @return DTO com as informações do usuário salvo, incluindo o ID gerado.
     */
    @PostMapping // Define que est e método lida com requisições HTTP POST.
    public UserResponseDto salvar( @Valid @RequestBody UserRequestDto userRequestDto) {
        // Chama o serviço para salvar o usuário e retorna a resposta.
        return userService.save(userRequestDto);
    }

    @PutMapping("/{id}") // Define que este método lida com requisições HTTP POST.
    public UserResponseDto update(
            @PathVariable Long id,
            @RequestBody UserRequestDto userRequestDto) {
        // Chama o serviço para salvar o usuário e retorna a resposta.

        return userService.update(userRequestDto, id);

    }

    @DeleteMapping(value = "/deletar/{id}")
    public void  delete(@PathVariable Long id) {
        userService.delete(id);
        ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User users = userService.buscarPorId(id);
        return ResponseEntity.ok(users);

    }

    @PatchMapping("/ativar/{id}") // Define que este método lida com requisições HTTP PATCH para ativar um usuário.
    public ResponseEntity<User> ativarUsuario(@PathVariable Long id) {
        User user = userService.ativarUsuario(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/desativar/{id}") // Define que este método lida com requisições HTTP PATCH para desativar um usuário.
    public ResponseEntity<User> desativarUsuario(@PathVariable Long id) {
        User user = userService.desativarUsuario(id);
        return ResponseEntity.ok(user);
    }



}
