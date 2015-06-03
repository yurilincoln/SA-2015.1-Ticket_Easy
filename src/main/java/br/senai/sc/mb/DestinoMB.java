package br.senai.sc.mb;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.dao.DestinoDao_OLD;
import br.senai.sc.entity.Destino;

@ManagedBean
public class DestinoMB {

	private Destino destino;
	private List<Destino> destinos;
	private DestinoDao_OLD destinoDao;
	
	@PostConstruct
	public void initMB(){
		this.destino = new Destino();
		destinoDao = new DestinoDao_OLD();
	}

//	public String salvar(){
//		DestinoDao_OLD dao = new DestinoDao_OLD();
//		dao.salvar(destino);
//		destino = new Destino();
//		return "listapontoturistico?faces-redirect=true";
//	}
//	
//	public String excluir(String idParam){
//		Long id = Long.valueOf(idParam);
//		destinoDao.excluir(id);
//		destinos = null;
//		return "";
//	}
//	
//	public String editar(String idParam){
//		Long id = Long.valueOf(idParam);
//		destino = destinoDao.buscarPorId(id);
//		return "cadastropontoturistico";
//	}

//	public List<Destino> getDestinos() {
//		if(destinos == null){
//			destinos = destinoDao.listarTodos();
//		}
//		return destinos;
//	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public DestinoDao_OLD getDestinoDao() {
		return destinoDao;
	}

	public void setDestinoDao(DestinoDao_OLD destinoDao) {
		this.destinoDao = destinoDao;
	}
	
	
}
