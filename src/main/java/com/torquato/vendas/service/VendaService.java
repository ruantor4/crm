package com.torquato.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torquato.vendas.model.Venda;
import com.torquato.vendas.repository.VendaRepository;

/**
 * Serviço responsável pela lógica de negócio relacionada aos venda.
 * Segue os princípios SOLID e utiliza padrões de design para melhor manutenção e escalabilidade.
 */
@Service
public class VendaService {
    
    @Autowired
    private VendaRepository vendaRepository;

    /**
     * Lista todas as vendas cadastrados no sistema.
     *
     * @return Lista de vendas.
     */
    public List<Venda> listarTodasVendas(){
        return vendaRepository.findAll();
    }

     /**
     * Busca uma venda pelo ID fornecido.
     *
     * @param id ID de venda a ser buscado.
     * @return venda encontrada.
     * @throws IllegalArgumentException Se o venda não for encontrada.
     */
    public Venda buscarVendaPorId(Long id){
        return vendaRepository.findById(id)
        .orElseThrow((() -> new IllegalArgumentException("Venda com ID " + id + " não encontrada.")));
    }

    /**
     * Adiciona uma nova venda ao sistema.
     *
     * @param venda Objeto venda a ser adicionado.
     * @return venda adicionado.
     */
    public Venda adicionarVenda(Venda venda){
        return vendaRepository.save(venda);
    }

    /**
     * Atualiza os dados de uma venda existente.
     *
     * @param id ID de venda a ser atualizado.
     * @param vendaAtualizado Dados atualizados da venda.
     * @return venda atualizada.
     * @throws IllegalArgumentException Se o venda não for encontrado.
     */
    public Venda atualizarVenda(Long id, Venda vendaAtualizada){
        return vendaRepository.findById(id)
        .map(venda -> {
            venda.setCliente(vendaAtualizada.getCliente());
            venda.setQuantidade(vendaAtualizada.getQuantidade());
            venda.setTotal(vendaAtualizada.getTotal());
            venda.setItens(vendaAtualizada.getItens());
            return vendaRepository.save(venda);
        })
        .orElseThrow(() -> new IllegalArgumentException("Venda com ID " + id + " não encontrada."));
    }

     /**
     * Remove uma venda do sistema com base no ID.
     *
     * @param id ID de venda a ser removido.
     */
    public void removerVenda(Long id){
        buscarVendaPorId(id);
        vendaRepository.deleteById(id);
    }

     /**
     * Retorna detalhes formatados de um venda específico.
     *
     * @param id ID de venda.
     * @return String com os detalhes da venda.
     */
    public String getDetalhesVenda(long id){
        Venda venda = buscarVendaPorId(id);
        return String.format("Cliente: %s | Quantidade: %s | Produtos %s | Total %s", 
        venda.getCliente(), venda.getQuantidade(), venda.getItens(), venda.getTotal());
    }
}
