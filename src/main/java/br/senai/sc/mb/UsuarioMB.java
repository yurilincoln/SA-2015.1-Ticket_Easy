package br.senai.sc.mb;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.senai.sc.dao.UsuarioDao;
import br.senai.sc.entity.Usuario;

@ManagedBean
public class UsuarioMB {

	private Usuario usuario;
	private List<Usuario> usuarios;
	private UsuarioDao usuarioDao;
	
	@PostConstruct
	public void initMB(){
		this.usuario = new Usuario();
		usuarioDao = new UsuarioDao();
	}

	public String cadastrar(){
		String usuarioComum = null;
		usuario.setTipodeUsuario(usuarioComum);
		usuarioDao.cadastrar(usuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro efetuado com sucesso!"));
		return "/login";
	}
	
	public String cadastrarAdmin(){
		String usuarioAdmin = null;
		usuario.setTipodeUsuario(usuarioAdmin);
		usuarioDao.cadastrar(usuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro efetuado com sucesso!"));
		return "listaadmin";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		usuarioDao.excluir(id);
		usuarios = null;
		return "";
	}
	
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		usuario = usuarioDao.buscarPorId(id);
		return "cadastrousuario";
	}
	
	public String editarAdmin(String idParam){
		Long id = Long.valueOf(idParam);
		usuario = usuarioDao.buscarPorId(id);
		return "cadastroadmin";
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		if(usuarios == null){
			usuarios = usuarioDao.listarTodos();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	
	
}
