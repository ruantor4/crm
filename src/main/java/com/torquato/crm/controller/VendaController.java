package com.torquato.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torquato.crm.model.Venda;
import com.torquato.crm.service.VendaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * Controlador responsável por gerenciar as operações relacionadas as vendas.
 * Fornece endpoints para criar, atualizar, remover e buscar vendas.
 */
@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    
    @Autowired
    private VendaService vendaService;

    /**
     * Endpoint para listar todos as vendas cadastrados.
     *
     * @return ResponseEntity contendo a lista de vendas e status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Venda>> listarTodasVendas(){
        List<Venda> vendas = vendaService.listarTodasVendas();
        return ResponseEntity.ok().body(vendas);
    }

     /**
     * Endpoint para buscar uma venda pelo ID.
     *
     * @param id ID de venda a ser buscado.
     * @return ResponseEntity contendo a venda encontrada e status 200 (OK).
     */
    @GetMapping("{id}")
    public ResponseEntity<Venda> buscarVendaPorId(@PathVariable Long id){
        try {
            Venda venda = vendaService.buscarVendaPorId(id);
            return ResponseEntity.ok().body(venda);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para adicionar uma nova venda.
     *
     * @param venda Dados de venda a ser adicionado.
     * @return ResponseEntity contendo a venda adicionado e status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Venda> adicionarVenda(@RequestBody Venda venda){
        Venda novaVenda = vendaService.adicionarVenda(venda);
        return ResponseEntity.ok().body(novaVenda);
    }

    /**
     * Endpoint para atualizar uma venda existente.
     *
     * @param id ID do venda a ser atualizado.
     * @param venda Dados atualizados de venda.
     * @return ResponseEntity contendo a venda atualizada e status 200 (OK).
     */
    @PutMapping("{id}")
    public ResponseEntity<Venda> atualizarVenda(@PathVariable Long id, @RequestBody Venda venda){
        try {
            Venda vendaAtualizada = vendaService.atualizarVenda(id, venda);
            return ResponseEntity.ok().body(vendaAtualizada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } 
    }

    /**
     * Endpoint para remover uma venda pelo ID.
     *
     * @param id ID de venda a ser removido.
     * @return ResponseEntity com status 204 (No Content) se a remoção for bem-sucedida.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> removerVenda(@PathVariable Long id){
        try {
            vendaService.removerVenda(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para obter detalhes formatados de uma venda específico.
     *
     * @param id ID de venda.
     * @return ResponseEntity contendo os detalhes da venda e status 200 (OK).
     */
    @GetMapping("{id}")
    public ResponseEntity<String> getDetalhesVenda(@PathVariable Long id){
       try {
            String detalhes = vendaService.getDetalhesVenda(id);
            return ResponseEntity.ok(detalhes);
       } catch (Exception e) {
            return ResponseEntity.notFound().build();
       } 
    }

}
