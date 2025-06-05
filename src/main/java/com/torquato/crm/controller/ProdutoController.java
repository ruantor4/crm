package com.torquato.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torquato.crm.model.Produto;
import com.torquato.crm.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos produtos.
 * Fornece endpoints para criar, atualizar, remover e buscar produtos.
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

     /**
     * Endpoint para listar todos os produtos cadastrados.
     *
     * @return ResponseEntity contendo a lista de produtos e status 200 (OK).
     */
    public ResponseEntity<List<Produto>> listarTodosProdutos(){
       List<Produto> produtos = produtoService.listarTodosProdutos();
        return ResponseEntity.ok().body(produtos);
    }

     /**
     * Endpoint para buscar um produto pelo ID.
     *
     * @param id ID do produto a ser buscado.
     * @return ResponseEntity contendo o produto encontrado e status 200 (OK).
     */
    @GetMapping("{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id){
        try {
            Produto produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok().body(produto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para adicionar um novo produto.
     *
     * @param produto Dados do produto a ser adicionado.
     * @return ResponseEntity contendo o produto adicionado e status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.adicionarPorduto(produto);
        return ResponseEntity.ok().body(novoProduto);
    }

    /**
     * Endpoint para atualizar um produto existente.
     *
     * @param id ID do produto a ser atualizado.
     * @param produto Dados atualizados do produto.
     * @return ResponseEntity contendo o produto atualizado e status 200 (OK).
     */
    @PutMapping("{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto){
        try {
            Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
            return ResponseEntity.ok().body(produtoAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para remover um produto pelo ID.
     *
     * @param id ID do produto a ser removido.
     * @return ResponseEntity com status 204 (No Content) se a remoção for bem-sucedida.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable Long id){
        try {
            produtoService.removerProduto(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para obter detalhes formatados de um produto específico.
     *
     * @param id ID do produto.
     * @return ResponseEntity contendo os detalhes do produto e status 200 (OK).
     */
    @GetMapping("{id}")
    public ResponseEntity<String> getDetalhesProduto(@PathVariable Long id){
        try {
            String detalhes = produtoService.getDetalhesProduto(id);
            return ResponseEntity.ok(detalhes);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
