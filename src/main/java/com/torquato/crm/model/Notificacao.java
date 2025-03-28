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
 * Representa uma notificação enviada pelo sistema.
 * Contém informações sobre o título, mensagem, tipo e data de envio da notificação.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notificacao {

    /**
     * Identificador único da notificação.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    /**
     * Mensagem detalhada da notificação.
     */
    private String mensagem;

    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    /**
     * Tipo da notificação, como "erro", "sucesso", etc.
     */
    private String tipo;

    /**
     * Data e hora em que a notificação foi enviada.
     */
    private Date dataEnvio;
}
