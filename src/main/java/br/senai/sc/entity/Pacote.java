package br.senai.sc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pacote {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String valor;
	
	@ManyToOne
	private QuantidadeDePontoTuristico qntdDePontoTuristico;
	
	public QuantidadeDePontoTuristico getQntdDePontoTuristico() {
		return qntdDePontoTuristico;
	}
	public void setQntdDePontoTuristico(
			QuantidadeDePontoTuristico qntdDePontoTuristico) {
		this.qntdDePontoTuristico = qntdDePontoTuristico;
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
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
		
}
