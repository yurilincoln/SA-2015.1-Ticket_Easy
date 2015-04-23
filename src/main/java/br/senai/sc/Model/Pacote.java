package br.senai.sc.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pacote {

	@Id
	@GeneratedValue
	private Long id;
	private String cidade;
	private String estado;
	private String bairro;
	private String descricao;
	private String horaFuncionamento;
	private Double valor;
	private String obersevacoes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getHoraFuncionamento() {
		return horaFuncionamento;
	}
	public void setHoraFuncionamento(String horaFuncionamento) {
		this.horaFuncionamento = horaFuncionamento;
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
	
}
