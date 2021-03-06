package br.senai.sc.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.dao.UsuarioDao;
import br.senai.sc.entity.Pedido;
import br.senai.sc.entity.Usuario;

@ManagedBean
@SessionScoped
public class SessaoMB {

	private Usuario usuarioLogar;
	private Usuario usuarioLogado;
	private Pedido pedido;
	
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
			return "/logado/index?faces-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usu�rio ou senha inv�lido."));
		return "/login";
	}
	
	private boolean checkLogin(Usuario usuarioEncontrado) {
		return usuarioEncontrado != null 
				&& usuarioLogar.getEmail().equals(usuarioEncontrado.getEmail()) 
				&& usuarioLogar.getSenha().equals(usuarioEncontrado.getSenha());
	}
	
	public String logout(){
		usuarioLogado = null;
		return "/login?faces-redirect=true";
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}