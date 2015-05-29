package br.senai.sc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuantidadeDePontoTuristico {
	
	@Id
	@GeneratedValue
	private Long id;
	private int qntdDePontoTuristico;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQntdDePontoTuristico() {
		return qntdDePontoTuristico;
	}
	public void setQntdDePontoTuristico(int qntdDePontoTuristico) {
		this.qntdDePontoTuristico = qntdDePontoTuristico;
	}
	
}
