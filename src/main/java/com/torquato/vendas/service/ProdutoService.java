package com.torquato.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torquato.vendas.model.Produto;
import com.torquato.vendas.repository.ProdutoRepository;

/**
 * Serviço responsável pela lógica de negócio relacionada aos produtos.
 * Segue os princípios SOLID e utiliza padrões de design para melhor manutenção e escalabilidade.
 */
@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

     /**
     * Lista todos os produtos cadastrados no sistema.
     *
     * @return Lista de produtos.
     */
    public List<Produto> listarTodosProdutos(){
        return produtoRepository.findAll();
    }

     /**
     * Busca um produto pelo ID fornecido.
     *
     * @param id ID do produto a ser buscado.
     * @return Produto encontrado.
     * @throws IllegalArgumentException Se o produto não for encontrado.
     */
    public Produto buscarProdutoPorId(Long id){
            return produtoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Produto com ID " + id + " não encontrado."));      
    }

    /**
     * Adiciona um novo produto ao sistema.
     *
     * @param produto Objeto produto a ser adicionado.
     * @return produto adicionado.
     */
    public Produto adicionarPorduto(Produto produto){
        return produtoRepository.save(produto);
    }

    /**
     * Atualiza os dados de um produto existente.
     *
     * @param id ID do produto a ser atualizado.
     * @param produtoAtualizado Dados atualizados do produto.
     * @return produto atualizado.
     * @throws IllegalArgumentException Se o produto não for encontrado.
     */
    public Produto atualizarProduto(Long id, Produto produtoAtualizado){
        return produtoRepository.findById(id)
        .map(produto -> {
                produto.setNome(produtoAtualizado.getNome());
                produto.setPreco(produtoAtualizado.getPreco());
                produto.setDescricao(produtoAtualizado.getDescricao());
                return produtoRepository.save(produto);
        })
        .orElseThrow(() -> new IllegalArgumentException("Produto com ID " + id + " não encontrado."));
    }

     /**
     * Remove um produto do sistema com base no ID.
     *
     * @param id ID do produto a ser removido.
     */
    public void removerProduto(Long id){
        buscarProdutoPorId(id);
        produtoRepository.deleteById(id);
        
    }

    /**
     * Retorna detalhes formatados de um produto específico.
     *
     * @param id ID do produto.
     * @return String com os detalhes do produto.
     */
    public String getDetalhesProduto(Long id){
        Produto produto = buscarProdutoPorId(id);
        return String.format("Produto: %s | Preço: %s | Descrição: %s", 
                produto.getNome(), produto.getPreco(), produto.getDescricao());
        
    }
}
