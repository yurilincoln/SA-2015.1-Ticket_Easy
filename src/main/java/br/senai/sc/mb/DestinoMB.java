package br.senai.sc.mb;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.senai.sc.dao.DestinoDao;
import br.senai.sc.entity.Destino;

@ManagedBean
public class DestinoMB {

	private Destino destino;
	private List<Destino> destinos;
	private DestinoDao destinoDao;
	
	@PostConstruct
	public void initMB(){
		this.destino = new Destino();
		destinoDao = new DestinoDao();
	}

	public String salvar(){
		destinoDao.salvar(destino);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
		return "listapontoturistico";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		destinoDao.excluir(id);
		destinos = null;
		return "";
	}
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		destino = destinoDao.buscarPorId(id);
		return "cadastropontoturistico";
	}

	public List<Destino> getDestinos() {
		if(destinos == null){
			destinos = destinoDao.listarTodos();
		}
		return destinos;
	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public DestinoDao getDestinoDao() {
		return destinoDao;
	}

	public void setDestinoDao(DestinoDao destinoDao) {
		this.destinoDao = destinoDao;
	}
	
	
}
