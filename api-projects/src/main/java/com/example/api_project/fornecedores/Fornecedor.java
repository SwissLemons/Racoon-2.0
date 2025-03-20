package com.example.api_project.fornecedores;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "contato", nullable = false)
    private String contato;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "numero", nullable = false)
    private String numero;
    
    @Column(name = "bairro", nullable = false)
    private String bairro;
    
    @Column(name = "complemento")
    private String complemento;
    
    @Column(name = "cidade", nullable = false)
    private String cidade;
    
    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "data_cadastro", insertable = false, updatable = false)
    private Date data_cadastro;

    public Fornecedor() {} // exlusiva para uso do JPA
    
    public Fornecedor(	
	    			String nome,
	    			String cnpj,
	    			String contato,
	    			String email,
	    			String rua,
	    			String numero,
	    			String bairro,
	    			String complemento,
	    			String cidade,
	    			String estado
                   ) {
    	this.nome = nome;
    	this.cnpj = cnpj;
    	this.contato = contato;
    	this.email = email;
    	this.rua = rua;
    	this.numero = numero;
    	this.bairro = bairro;
    	this.complemento = complemento;
    	this.cidade = cidade;
    	this.estado = estado;
    }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
    
}