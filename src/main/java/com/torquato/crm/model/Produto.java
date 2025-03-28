package com.torquato.crm.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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

    /**
     * Identificador único do produto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do produto.
     */
    private String nome;

    /**
     * Preço unitário do produto.
     */
    private Double preco;

    /**
     * Descrição detalhada do produto.
     */
    private String descricao;

    /**
     * Produto relacionado com venda.
     */
    @ManyToOne
    @JoinColumn(name = "sistema_crm_id")
    private SistemaCRM sistemaCRM;

    /**
     * Relacionamento com a venda.
     * Cada produto pode ser vendido em várias vendas, sendo um relacionamento N:M.
     */
    @ManyToMany
    @JoinTable(
        name = "item_venda", 
        joinColumns = @JoinColumn(name = "produto_id"), 
        inverseJoinColumns = @JoinColumn(name = "venda_id")
    )
    private List<Venda> vendas;  // Relacionamento N:M com Venda
}

