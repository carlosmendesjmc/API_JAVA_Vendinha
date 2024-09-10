package com.api_vendinha.api.domain.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.StyledEditorKit;

@Data
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String cnpj;
    private Boolean is_active;

}

