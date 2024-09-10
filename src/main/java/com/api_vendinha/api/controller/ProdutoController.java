package com.api_vendinha.api.controller;

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.dtos.response.ProdutoResponseDto;
import com.api_vendinha.api.domain.entities.Produto;
import com.api_vendinha.api.domain.service.ProdutoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoServiceInterface produtoService;

    @Autowired
    public ProdutoController(ProdutoServiceInterface produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoResponseDto salvar(@Valid @RequestBody ProdutoRequestDto produtoRequestDto) {
        return produtoService.save(produtoRequestDto);
    }

    @PutMapping("/update/{id}")
    public ProdutoResponseDto update( @RequestBody ProdutoRequestDto produtoRequestDto, @PathVariable Long id) {
        return produtoService.update(produtoRequestDto, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById (@PathVariable Long id) {
        Produto produtos = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produtos);

    }
}
