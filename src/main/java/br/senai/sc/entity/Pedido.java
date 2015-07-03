package br.senai.sc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pedido {
	
	
	@Id
	@GeneratedValue
	private Long id;
	private double total;
	private String data;
	
	@ManyToMany(cascade=CascadeType.DETACH)
	private List<Destino> destinos;
	@ManyToMany(cascade=CascadeType.DETACH)
	private List<Pacote> pacotes;
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Destino> getDestinos() {
		return destinos;
	}
	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}
	public List<Pacote> getPacotes() {
		return pacotes;
	}
	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}
	
	
	
	
	
}
