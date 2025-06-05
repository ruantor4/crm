package com.torquato.crm.controller;

import com.torquato.crm.model.Cliente;
import com.torquato.crm.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos clientes.
 * Fornece endpoints para criar, atualizar, remover e buscar clientes.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

     /**
     * Endpoint para listar todos os clientes cadastrados.
     *
     * @return ResponseEntity contendo a lista de clientes e status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodosClientes() {
        List<Cliente> clientes = clienteService.listarTodosClientes();
        return ResponseEntity.ok().body(clientes);
    }

    /**
     * Endpoint para buscar um cliente pelo ID.
     *
     * @param id ID do cliente a ser buscado.
     * @return ResponseEntity contendo o cliente encontrado e status 200 (OK).
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.buscarClientePorId(id);
            return ResponseEntity.ok(cliente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para adicionar um novo cliente.
     *
     * @param cliente Dados do cliente a ser adicionado.
     * @return ResponseEntity contendo o cliente adicionado e status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Cliente> adicionarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.adicionarCliente(cliente);
        return ResponseEntity.ok().body(novoCliente);
    
    }

    /**
     * Endpoint para atualizar um cliente existente.
     *
     * @param id ID do cliente a ser atualizado.
     * @param cliente Dados atualizados do cliente.
     * @return ResponseEntity contendo o cliente atualizado e status 200 (OK).
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
            return ResponseEntity.ok().body(clienteAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para remover um cliente pelo ID.
     *
     * @param id ID do cliente a ser removido.
     * @return ResponseEntity com status 204 (No Content) se a remoção for bem-sucedida.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCliente(@PathVariable Long id) {
        try {
            clienteService.removerCliente(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }    
    }

    /**
     * Endpoint para obter detalhes formatados de um cliente específico.
     *
     * @param id ID do cliente.
     * @return ResponseEntity contendo os detalhes do cliente e status 200 (OK).
     */
    @GetMapping("/{id}/detalhes")
    public ResponseEntity<String> getDetalhesCliente(@PathVariable Long id) {
        try {
            String detalhes = clienteService.getDetalhesCliente(id);
            return ResponseEntity.ok(detalhes);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }
}
