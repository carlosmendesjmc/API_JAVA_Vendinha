package com.api_vendinha.api.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private String name;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco")
    private Double preco;




}
