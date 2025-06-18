package com.torquato.vendas.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * Classe responsável por gerar relatórios no sistema CRM.
 * Contém métodos que serão implementados na camada de serviço.
 */
@Data
@Entity
public class Relatorio {
    
    @Id
    private Long id;

    @ManyToMany
    private List<Venda> vendas; // Relatório pode incluir várias vendas

    @ManyToMany
    private List<Cliente> clientes; // Relatório pode incluir vários clientes

}