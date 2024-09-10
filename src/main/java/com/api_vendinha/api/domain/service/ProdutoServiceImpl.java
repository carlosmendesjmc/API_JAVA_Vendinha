package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.Infrastructure.repository.ProdutoRepository;
import com.api_vendinha.api.Infrastructure.repository.UserRepository;
import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto;
import com.api_vendinha.api.domain.entities.Produto;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Parameter;

@Service
public class ProdutoServiceImpl implements ProdutoServiceInterface {

    private final ProdutoRepository produtoRepository;
    private final ParameterNamesModule parameterNamesModule;


    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository, ParameterNamesModule parameterNamesModule, UserRepository userRepository){
        this.produtoRepository = produtoRepository;
        this.parameterNamesModule = parameterNamesModule;
         }

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, ParameterNamesModule parameterNamesModule) {
        this.produtoRepository = produtoRepository;
        this.parameterNamesModule = parameterNamesModule;
    }

    @Override
    public ProdutoResponseDto save(ProdutoRequestDto produtoRequestDto) {
        Produto produto = new Produto();
        produto.setName(produtoRequestDto.getName());
        produto.setQuantidade(Integer.valueOf(produtoRequestDto.getQuantidade()));
        produto.setPreco(produtoRequestDto.getPreco());

        Produto savedProduto = produtoRepository.save(produto);

        ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto();
        produtoResponseDto.setName(savedProduto.getName());
        produtoResponseDto.setQuantidade(savedProduto.getQuantidade());
        produtoResponseDto.setPreco(savedProduto.getPreco());

        return produtoResponseDto;



    }

    @Override
    public ProdutoResponseDto update(ProdutoRequestDto produtoRequestDto, Long id) {
        Produto produtoExist = produtoRepository.findById(id).orElseThrow();

        produtoExist.setName(produtoRequestDto.getName());
        produtoExist.setQuantidade(Integer.valueOf(produtoRequestDto.getQuantidade()));
        produtoExist.setPreco(produtoRequestDto.getPreco());
        produtoRepository.save(produtoExist);

        ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto();
        produtoResponseDto.setName(produtoRequestDto.getName());
        produtoResponseDto.setQuantidade(produtoExist.getQuantidade());
        produtoResponseDto.setPreco(produtoExist.getPreco());

        return produtoResponseDto;
    }

    @Override
    public Produto buscarPorId(Long id) {
        return null;
    }


}
