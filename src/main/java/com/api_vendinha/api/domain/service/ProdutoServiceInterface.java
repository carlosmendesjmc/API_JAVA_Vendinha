package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto;
import com.api_vendinha.api.domain.entities.Produto;

import java.util.List;

public interface ProdutoServiceInterface {



    ProdutoResponseDto save(ProdutoRequestDto produtoRequestDto);
    ProdutoResponseDto update(ProdutoRequestDto produtoRequestDto, Long id);
    List<Produto>findall();
    Produto findById(Long id);
    void deleteById(Long id);
}
