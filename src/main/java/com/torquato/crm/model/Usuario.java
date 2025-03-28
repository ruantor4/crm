package com.torquato.crm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    /**
     * Identificador único do usuário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome completo do usuário.
     */
    private String nome;

    /**
     * Nome de usuário utilizado para login.
     */
    private String login;

    /**
     * Senha de acesso do usuário.
     */
    private String senha;

    /**
     * Indica se o usuário está ativo no sistema.
     */
    private boolean ativo;

    /**
     * Perfil de acesso do usuário (ex: "admin", "usuario").
     */
    private String perfil;

    /**
     * Data de criação do cadastro do usuário.
     */
    private Date dataCriacao;

    /**
     * Data e hora do último login do usuário.
     */
    private Date ultimoLogin;

    /**
     * Relacionamento com SistemaCRM.
     */
    
    @OneToOne
    private SistemaCRM sistemaCRM;  // Relacionamento 1:1 com SistemaCRM
}
