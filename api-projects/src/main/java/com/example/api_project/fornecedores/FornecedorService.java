package com.example.api_project.fornecedores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {
	@Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor criarFornecedor(String nome, String cnpj, String contato, String email, String rua, 
		String numero, String bairro, String complemento, String cidade, String estado) throws Exception {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Fornecedor deve conter um nome valido.");
        }
        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("Fornecedor deve conter um cnpj valido.");
        }
        if (contato == null || contato.trim().isEmpty()) {
            throw new IllegalArgumentException("Fornecedor deve conter um contato valido.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Fornecedor deve conter um email valido.");
        }
        if (rua == null || rua.trim().isEmpty()) {
            throw new IllegalArgumentException("Fornecedor deve conter uma rua valido.");
        }
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Fornecedor deve conter um numero valido.");
        }
        if (bairro == null || bairro.trim().isEmpty()) {
            throw new IllegalArgumentException("Fornecedor deve conter um bairro valido.");
        }
        if (cidade == null || cidade.trim().isEmpty()) {
            throw new IllegalArgumentException("Fornecedor deve conter um nome valido.");
        }
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("Fornecedor deve conter um estado valido.");
        }

        Fornecedor novoFornecedor = new Fornecedor(
        		nome,
    			cnpj,
    			contato,
    			email,
    			rua,
    			numero,
    			bairro,
    			complemento,
    			cidade,
    			estado
        );

        return fornecedorRepository.save(novoFornecedor);
    }
}
