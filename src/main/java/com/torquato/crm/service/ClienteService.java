package com.torquato.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torquato.crm.model.Cliente;
import com.torquato.crm.repository.ClienteRepository;

/**
 * Serviço responsável pela lógica de negócio relacionada aos clientes.
 * Segue os princípios SOLID e utiliza padrões de design para melhor manutenção e escalabilidade.
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

     /**
     * Lista todos os clientes cadastrados no sistema.
     *
     * @return Lista de clientes.
     */
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

     /**
     * Busca um cliente pelo ID fornecido.
     *
     * @param id ID do cliente a ser buscado.
     * @return Cliente encontrado.
     * @throws IllegalArgumentException Se o cliente não for encontrado.
     */
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente com ID " + id + " não encontrado."));
    }

    /**
     * Adiciona um novo cliente ao sistema.
     *
     * @param cliente Objeto Cliente a ser adicionado.
     * @return Cliente adicionado.
     */
    public Cliente adicionarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Atualiza os dados de um cliente existente.
     *
     * @param id ID do cliente a ser atualizado.
     * @param clienteAtualizado Dados atualizados do cliente.
     * @return Cliente atualizado.
     * @throws IllegalArgumentException Se o cliente não for encontrado.
     */
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setEmail(clienteAtualizado.getEmail());
                    cliente.setTelefone(clienteAtualizado.getTelefone());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new IllegalArgumentException("Cliente com ID " + id + " não encontrado."));
    }

    /**
     * Remove um cliente do sistema com base no ID.
     *
     * @param id ID do cliente a ser removido.
     */
    public void removerCliente(Long id) {
        buscarClientePorId(id);
        clienteRepository.deleteById(id);
    }

    /**
     * Retorna detalhes formatados de um cliente específico.
     *
     * @param id ID do cliente.
     * @return String com os detalhes do cliente.
     */
    public String getDetalhesCliente(Long id) {
        Cliente cliente = buscarClientePorId(id);
        return String.format("Cliente: %s | Email: %s | Telefone: %s", 
                cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }
}
