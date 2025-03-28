package com.torquato.crm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa um cliente no sistema CRM.
 * Contém informações pessoais e o histórico de compras do cliente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    /**
     * Identificador único do cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome completo do cliente.
     */
    private String nome;

    /**
     * Endereço de e-mail do cliente para contato.
     */
    private String email;

    /**
     * Número de telefone do cliente para contato.
     */
    private String telefone;

    /**
     * Endereço residencial ou comercial do cliente.
     */
    private String endereco;

    /**
     * Histórico de compras realizadas pelo cliente.
     */
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venda> historicoCompras;

     /**
     * Notificações do cliente.
     */
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Notificacao> notificacoes; 

    @ManyToOne  // Define que um cliente pertence a um SistemaCRM
    private SistemaCRM sistemaCRM;
}

 