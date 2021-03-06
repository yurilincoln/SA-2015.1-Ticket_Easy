package br.senai.sc.mb;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.senai.sc.dao.AdministradorDao;
import br.senai.sc.entity.Administrador;

@ManagedBean
public class AdministradorMB {

	private Administrador administrador;
	private List<Administrador> administradores;
	private AdministradorDao administradorDao;
	
	@PostConstruct
	public void initMB(){
		this.administrador = new Administrador();
		administradorDao = new AdministradorDao();
	}
	
	public String cadastrar(){
		if(!administrador.getSenha().equals(administrador.getConfirmarsenha())){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("As senhas devem ser iguais!"));
			return "";
		}
		if(administrador.getId() >= 0){
			administradorDao.cadastrar(administrador);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alteracoes efetuadas com sucesso!"));
			return "/admin/index?faces-redirect=true"; 
		}
		administradorDao.cadastrar(administrador);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro efetuado com sucesso!"));
		return "listaadmin";
	}
	
	public String perfil(String idParam){
		Long id = Long.valueOf(idParam);
		administrador = administradorDao.buscarPorId(id);
		return "/admin/administradorlogado";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		administradorDao.excluir(id);
		administradores = null;
		return "";
	}
	
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		administrador = administradorDao.buscarPorId(id);
		return "cadastroadmin";
	}
	
	public List<Administrador> getAdministradores() {
		if(administradores == null){
			administradores = administradorDao.listarTodos();
		}
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public AdministradorDao getAdministradorDao() {
		return administradorDao;
	}

	public void setAdministradorDao(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
	}

	

	
	
}