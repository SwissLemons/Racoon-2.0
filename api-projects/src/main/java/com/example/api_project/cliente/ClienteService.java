package com.example.api_project.cliente;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Clob;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import com.example.api_project.produto.Produto;
import com.example.api_project.produto.ProdutoRepository;

public class ClienteService {

	@Autowired
    private ClienteRepository clienteRepository;
	
	public Cliente criarCliente(String nome, String cnpj, String telefone, String email, String regimeTributario,
			String cep, String cidade, String bairro, String rua, int n, String complemento, Clob observacao) {
        
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente deve conter um nome valido.");
        }

        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente deve conter um cnpj valido.");
        }
        
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente deve conter um telefone valido.");
        }
        
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente deve conter um email valido.");
        }
        
        if (regimeTributario == null || regimeTributario.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente deve conter um regime tributario valido.");
        }
        
        if (cep == null || cep.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente deve conter um cep valido.");
        }
        
        if (cidade == null || cidade.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente deve conter uma cidade valido.");
        }
        
        if (rua == null || rua.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente deve conter uma rua valido.");
        }
        
        if (n == null || n <= 0) {
            throw new IllegalArgumentException("Cliente deve conter um numero valido.");
        }
        
        if (complemento == null || complemento.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente deve conter um complemento valido.");
        }

        Cliente novoCliente = new Cliente(
        		nome,
        		cnpj,
        		telefone,
        		email,
        		regimeTributario,
        		cep,
        		cidade,
        		bairro,
        		rua,
        		n,
        		complemento,
        		observacao
        );

        return clienteRepository.save(novoCliente);
	}	
}