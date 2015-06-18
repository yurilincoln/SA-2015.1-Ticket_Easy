package br.senai.sc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String email;
	private String senha;
	private String confirmarsenha;
	private String tipodeUsuario;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarsenha() {
		return confirmarsenha;
	}

	public void setConfirmarsenha(String confirmarsenha) {
		this.confirmarsenha = confirmarsenha;
	}

	public String getTipodeUsuario() {
		return tipodeUsuario;
	}

	public void setTipodeUsuario(String tipodeUsuario) {
		this.tipodeUsuario = tipodeUsuario;
	}

}
