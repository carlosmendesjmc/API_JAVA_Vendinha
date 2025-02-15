package com.api_vendinha.api.domain.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoResponseDto {
    private Long id;
    private String name;
    private Integer quantidade;
    private Double preco;
}
