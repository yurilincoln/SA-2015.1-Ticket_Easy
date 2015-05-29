package br.senai.sc.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class AdicionarPacote {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
