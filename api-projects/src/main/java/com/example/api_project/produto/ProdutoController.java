package com.example.api_project.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(
    		@RequestParam("codigo") String codigo,
    		@RequestParam("nome") String nome,
    		@RequestParam("descricao") String descricao,
    		@RequestParam("deposito") String deposito,
    		@RequestParam("imagem") MultipartFile imagem,
    		@RequestParam("custo") Double custo,
    		@RequestParam("valor") Double valor
            ) {

        try {
            Produto novoProduto = service.criarProduto(codigo, nome, descricao, deposito, imagem, custo,
            		valor); 
            System.out.println(novoProduto);
            return ResponseEntity.status(201).body(novoProduto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
 