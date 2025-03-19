package com.example.api_project.cliente;

import java.sql.Clob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listarProdutos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(
    		@RequestParam("nome") String nome,
    		@RequestParam("cnpj") String cnpj,
    		@RequestParam("telefone") String telefone,
    		@RequestParam("email") String email,
    		@RequestParam("regimeTributario") String regimeTributario,
    		@RequestParam("cep") String cep,
    		@RequestParam("cidade") String cidade,
    		@RequestParam("bairo") String bairro,
    		@RequestParam("rua") String rua,
    		@RequestParam("n") int n,
    		@RequestParam("complemento") String complemento,
    		@RequestParam("observacao") Clob observacao
            ) {

        try {
            Cliente novoCliente = service.criarCliente(nome, cnpj, telefone, email, regimeTributario, 
            		cep, cidade, bairro, rua, n, complemento, observacao); 
            System.out.println(novoCliente);
            return ResponseEntity.status(201).body(novoCliente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}