package com.torquato.crm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;
    private Double total;

   /**
    * Itens relacionados a esta venda (rel. 1:N via ItemVenda).
    */
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itens;

    @ManyToOne
    private SistemaCRM sistemaCRM;  // Relacionamento ManyToOne com SistemaCRM

    /**
     * Cliente que realizou a compra.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
