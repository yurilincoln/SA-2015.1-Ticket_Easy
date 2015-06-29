package br.senai.sc.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.dao.AdministradorDao;
import br.senai.sc.entity.Administrador;

@ManagedBean
@SessionScoped
public class SessaoAdminMB {
	
	private Administrador administradorLogar;
	private Administrador administradorLogado;
	
	@PostConstruct
	public void init(){
		administradorLogar = new Administrador();
	}
	
	public boolean isLogadoAdmin(){
		return administradorLogado != null;
	}
	
	public String login(){
		AdministradorDao administradordao = new AdministradorDao();
		Administrador administradorValida = administradordao.buscaPorEmail(administradorLogar.getEmail());
			if(checkLogin(administradorValida)){
				administradorLogado = administradorValida;
				return "/admin/?faces-redirect=true";
			}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário ou senha inválido."));
		return "/loginadmin";
	}
	
	private boolean checkLogin(Administrador administradorEncontrado) {
		return administradorEncontrado != null 
				&& administradorLogar.getEmail().equals(administradorEncontrado.getEmail()) 
				&& administradorLogar.getSenha().equals(administradorEncontrado.getSenha());
	}
	
	public String logout(){
		administradorLogado = null;
		return "/loginadmin?face-redirect=true";
	}

	public Administrador getAdministradorLogar() {
		return administradorLogar;
	}

	public void setAdministradorLogar(Administrador administradorLogar) {
		this.administradorLogar = administradorLogar;
	}

	public Administrador getAdministradorLogado() {
		return administradorLogado;
	}

	public void setAdministradorLogado(Administrador administradorLogado) {
		this.administradorLogado = administradorLogado;
	}

	
}