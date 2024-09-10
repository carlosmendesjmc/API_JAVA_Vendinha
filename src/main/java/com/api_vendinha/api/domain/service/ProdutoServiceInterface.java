package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto;
import com.api_vendinha.api.domain.entities.Produto;

public interface ProdutoServiceInterface {



    ProdutoResponseDto save(ProdutoRequestDto produtoRequestDto);
    ProdutoResponseDto update(ProdutoRequestDto produtoRequestDto, Long id);

    Produto buscarPorId(Long id);
}
