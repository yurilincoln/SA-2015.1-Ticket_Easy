package br.senai.sc.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Pacote {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String valor;
	
	@ManyToMany
	private List<Pacote> idPacote;
	
	public List<Pacote> getIdPacote() {
		return idPacote;
	}
	public void setIdPacote(List<Pacote> idPacote) {
		this.idPacote = idPacote;
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
