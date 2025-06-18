package com.torquato.vendas.model;

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
 * Representa uma notificação enviada pelo sistema.
 * Contém informações sobre o título, mensagem, tipo e data de envio da notificação.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;
    private String tipo;
    private Date dataEnvio;

    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
