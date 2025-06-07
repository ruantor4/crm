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
 * Classe que representa um cliente no sistema CRM.
 * Contém informações pessoais e o histórico de compras do cliente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
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

    @ManyToOne
    @JoinColumn(name = "sistema_crm_id")
    private SistemaCRM sistemaCRM;
    }

 