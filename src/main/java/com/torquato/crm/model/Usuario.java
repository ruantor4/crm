package com.torquato.crm.model;

import java.util.Date;

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
 * Classe que representa um usuário no sistema CRM.
 * Contém informações para autenticação e controle de acesso.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String login;
    private String senha;
    private boolean ativo;
    private String perfil;
    private Date dataCriacao;
    private Date ultimoLogin;

    /**
     * Relacionamento com SistemaCRM.
     */
    @ManyToOne
    @JoinColumn(name = "sistema_crm_id")
    private SistemaCRM sistemaCRM;

}
