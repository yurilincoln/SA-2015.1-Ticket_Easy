package br.senai.sc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Destino {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String cidade;
	private String estado;
	private String bairro;
	private String descricao;
	private String horaAbertura;
	private String horaFechamento;
	private Double valor;
	private String obersevacoes;
	private String fotoDestino;
	
	public String getHoraAbertura() {
		return horaAbertura;
	}
	public void setHoraAbertura(String horaAbertura) {
		this.horaAbertura = horaAbertura;
	}
	public String getHoraFechamento() {
		return horaFechamento;
	}
	public void setHoraFechamento(String horaFechamento) {
		this.horaFechamento = horaFechamento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getObersevacoes() {
		return obersevacoes;
	}
	public void setObersevacoes(String obersevacoes) {
		this.obersevacoes = obersevacoes;
	}
	public String getFotoDestino() {
		return fotoDestino;
	}
	public void setFotoDestino(String fotoDestino) {
		this.fotoDestino = fotoDestino;
	}
		
}
