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
	private double valor;
	private String descricao;
	
	@ManyToMany
	private List<Destino> destinos;
	
	public List<Destino> getDestinos() {
		return destinos;
	}
	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}
	public String listaDestino(){
		StringBuilder lista = new StringBuilder();
		for(Destino d : destinos){
			if(lista.length() > 0){
				lista.append(", ");
			}
			lista.append(d.getNome());
		}
		
		return lista.toString();
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
