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
	private Usuario usuario;
	
	@PostConstruct
	public void init(){
		usuarioLogar = new Usuario();
	}
	
	public boolean isLogado(){
		return usuarioLogado != null;
	}
	
	public boolean usuarioAdministrador(){
		return usuario.getTipodeUsuario() != "usuarioComum";
	}
	
//	public String login(){
//		UsuarioDao dao = new UsuarioDao();
//		Usuario usuarioValida = dao.buscaPorEmail(usuarioLogar.getEmail());
//		if(usuarioValida.getTipodeUsuario().equals("usuarioAdmin"){
//			if(checkLogin(usuarioValida)){
//				usuarioLogado = usuarioValida;
//				return "/admin/index.xhtml?face-redirect=true";
//		}
//		if(checkLogin(usuarioValida)){
//			usuarioLogado = usuarioValida;
//			return "/logado/index.xhtml?face-redirect=true";
//		}
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário ou senha inválido."));
//		return "/login";
//	}
//	
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