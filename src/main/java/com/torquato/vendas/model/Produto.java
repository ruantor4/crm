package com.torquato.vendas.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa um produto no sistema CRM.
 * Armazena informações sobre produtos oferecidos pela empresa.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;
    private String descricao;

   /**
    * Itens relacionados a este produto (rel. 1:N via ItemVenda).
    */
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ItemVenda> itens;

    }

