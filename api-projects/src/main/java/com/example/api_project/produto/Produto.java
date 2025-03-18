	package com.example.api_project.produto;
import java.sql.Blob;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Lob
    @Column(name = "imagem")
    private Blob imagem;

    @Column(name = "deposito", nullable = false)
    private String deposito;

    @Column(name = "custo", nullable = false)
    private Double custo;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "data_criacao", insertable = false, updatable = false)
    private Date dataCriacao;

    @Column(name = "data_atualizacao", insertable = false, updatable = false)
    private Date dataAtualizacao;

    public Produto() {} // exlusiva para uso do JPA
    
    public Produto(String codigo,
                   String nome,
                   String descricao,
                   String deposito,
                   Blob imagem,
                   Double custo,
                   Double valor
                   ) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.deposito = deposito;
        this.imagem = imagem;
        this.custo = custo;
        this.valor = valor;
    }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDeposito() {
		return deposito;
	}
	public void setDeposito(String deposito) {
		this.deposito = deposito;
	}
	public Blob getImagem() {
		return imagem;
	}
	public void setImagem(Blob imagem) {
		this.imagem = imagem;
	}
	public Double getCusto() {
		return custo;
	}
	public void setCusto(Double custo) {
		this.custo = custo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}