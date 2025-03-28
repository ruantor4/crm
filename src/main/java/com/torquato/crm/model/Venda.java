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
 * Classe que representa uma venda no sistema CRM.
 * Contém informações sobre o cliente, produto, quantidade e valor total da venda.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venda {

    /**
     * Identificador único da venda.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cliente que realizou a compra.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    /**
     * Quantidade de produtos adquiridos na venda.
     */
    private int quantidade;

    /**
     * Valor total da venda calculado com base na quantidade e preço do produto.
     */
    private double total;

    @ManyToMany
    @JoinTable(
        name = "item_venda",
        joinColumns = @JoinColumn(name = "venda_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    @ManyToOne
    private SistemaCRM sistemaCRM;  // Relacionamento ManyToOne com SistemaCRM
}
