package com.torquato.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa um item de uma venda, associando um produto a uma venda com uma quantidade e valor total.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;
    private Double precoTotal;

    /** Produto vendido neste item. */
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    /** Venda à qual este item pertence. */
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

}
