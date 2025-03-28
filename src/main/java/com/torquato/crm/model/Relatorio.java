package com.torquato.crm.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Classe responsável por gerar relatórios no sistema CRM.
 * Contém métodos que serão implementados na camada de serviço.
 */
@Data
@Entity
public class Relatorio {
    
    @Id
    private Long id;  // Adicione um identificador único

    @ManyToMany
    private List<Venda> vendas; // Relatório pode incluir várias vendas

    @ManyToMany
    private List<Cliente> clientes; // Relatório pode incluir vários clientes

    /**
     * Relacionamento com o SistemaCRM.
     * Cada relatório está associado a um SistemaCRM específico.
     */
    @ManyToOne
    private SistemaCRM sistemaCRM;
}