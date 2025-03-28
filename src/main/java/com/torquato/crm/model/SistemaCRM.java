package com.torquato.crm.model;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe SistemaCRM representa o sistema central de gerenciamento de clientes, produtos, vendas e relatórios.
 * Ela é responsável por centralizar a gestão e organização de todos os dados necessários para o funcionamento do CRM.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SistemaCRM {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Lista de clientes associados ao SistemaCRM.
     * Cada cliente pode realizar diversas vendas e interagir com o sistema de notificações.
     * Relacionamento de agregação: O SistemaCRM contém uma lista de clientes.
     * 
     * @see Cliente
     */
    @OneToMany(mappedBy = "sistemaCRM")
    private List<Cliente> clientes;  // Agregação com Cliente
    
    /**
     * Lista de produtos disponíveis no SistemaCRM.
     * Os produtos podem ser vendidos em diversas transações, associando-os a vendas específicas.
     * Relacionamento de agregação: O SistemaCRM contém uma lista de produtos.
     * 
     * @see Produto
     */
    @OneToMany(mappedBy = "sistemaCRM")
    private List<Produto> produtos;  // Agregação com Produto
    
    /**
     * Lista de vendas realizadas no SistemaCRM.
     * Cada venda é associada a um cliente específico e pode envolver vários produtos.
     * Relacionamento de agregação: O SistemaCRM contém uma lista de vendas.
     * 
     * @see Venda
     */
    @OneToMany(mappedBy = "sistemaCRM")
    private List<Venda> vendas;  // Agregação com Venda
    
    /**
     * Lista de relatórios gerados a partir das vendas e interações do SistemaCRM.
     * Os relatórios podem ser gerados com base em diversas métricas e critérios.
     * Relacionamento de agregação: O SistemaCRM contém uma lista de relatórios.
     * 
     * @see Relatorio
     */
    @OneToMany(mappedBy = "sistemaCRM")
    private List<Relatorio> relatorios;  // Agregação com Relatório
    
    /**
     * Usuário associado ao SistemaCRM.
     * O SistemaCRM pode ser utilizado por um único usuário, que terá permissões específicas para interagir com o sistema.
     * Relacionamento de associação: O SistemaCRM é associado a um único Usuário.
     * 
     * @see Usuario
     */
    @OneToOne(mappedBy = "sistemaCRM")
    private Usuario usuario;  // Associação 1:1 com Usuário
}
