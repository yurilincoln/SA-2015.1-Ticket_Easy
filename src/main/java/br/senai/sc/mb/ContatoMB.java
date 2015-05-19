package br.senai.sc.mb;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ContatoMB {

	private String nome;
	private String email;
	private String comentario;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String enviar(){
		System.out.println("Nome: " + nome);
		System.out.println("E-Mail: " + email);
		System.out.println("Comentario: " + comentario);
		
		nome = "";
		email = "";
		comentario = "";
		
		return "";
	}
	
}
