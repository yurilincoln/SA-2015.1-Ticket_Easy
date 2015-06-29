package br.senai.sc.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.dao.UsuarioDao;
import br.senai.sc.entity.Usuario;

@ManagedBean
@SessionScoped
public class SessaoMB {

	private Usuario usuarioLogar;
	private Usuario usuarioLogado;
	
	@PostConstruct
	public void init(){
		usuarioLogar = new Usuario();
	}
	
	public boolean isLogado(){
		return usuarioLogado != null;
	}
	
	public String login(){
		
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuarioValida = usuarioDao.buscaPorEmail(usuarioLogar.getEmail());
//		
//		AdministradorDao administradordao = new AdministradorDao();
//		Administrador administradorValida = administradordao.buscaPorEmail(administradorLogar.getEmail());
//		
//		if(administradorValida.getTipodeUsuario().equals("usuarioAdmin")){
//			if(checkLoginAdmin(administradorValida)){
//				administradorLogado = administradorValida;
//				return "/admin/*?face-redirect=true";
//			}
//		}else{
		if(checkLogin(usuarioValida)){
			usuarioLogado = usuarioValida;
			return "/logado/index?face-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário ou senha inválido."));
		return "/login";
	}
	
	private boolean checkLogin(Usuario usuarioEncontrado) {
		return usuarioEncontrado != null 
				&& usuarioLogar.getEmail().equals(usuarioEncontrado.getEmail()) 
				&& usuarioLogar.getSenha().equals(usuarioEncontrado.getSenha());
	}
	
	public String logout(){
		usuarioLogado = null;
		return "/login?face-redirect=true";
	}
	

	public Usuario getUsuarioLogar() {
		return usuarioLogar;
	}

	public void setUsuarioLogar(Usuario usuarioLogar) {
		this.usuarioLogar = usuarioLogar;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}