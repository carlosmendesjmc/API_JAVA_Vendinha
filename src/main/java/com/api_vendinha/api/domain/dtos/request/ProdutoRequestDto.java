package com.api_vendinha.api.domain.dtos.request;

import com.api_vendinha.api.domain.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoRequestDto {
    private Long id;
    private String name;
    private Integer quantidade;
    private Double preco;

}
