package com.example.api_project.fornecedores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private FornecedorService service;

    @GetMapping
    public List<Fornecedor> listarFornecedores() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Fornecedor> criarFornecedor(
    		@RequestParam("nome") String nome,
    		@RequestParam("cnpj") String cnpj,
    		@RequestParam("contato") String contato,
    		@RequestParam("email") String email,
    		@RequestParam("rua") String rua,
    		@RequestParam("numero") String numero,
    		@RequestParam("bairro") String bairro,
    		@RequestParam("complemento") String complemento,
    		@RequestParam("cidade") String cidade,
    		@RequestParam("estado") String estado
            ) {

        try {
            Fornecedor novoFornecedor = service.criarFornecedor(nome, cnpj, contato, email, rua, numero, bairro, 
            		complemento, cidade, estado); 
            System.out.println(novoFornecedor);
            return ResponseEntity.status(201).body(novoFornecedor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}