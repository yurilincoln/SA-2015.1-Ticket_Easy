package br.senai.sc.mb;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.dao.PacoteDao;
import br.senai.sc.entity.Pacote;

@ManagedBean
public class PacoteMB {

	private Pacote pacote;
	private List<Pacote> pacotes;
	private PacoteDao pacoteDao;
	
	@PostConstruct
	public void initMB(){
		this.pacote = new Pacote();
		pacoteDao = new PacoteDao();
	}

	public String salvar(){
		PacoteDao dao = new PacoteDao();
		dao.salvar(pacote);
		pacote = new Pacote();
		return "listapacoteturistico?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		pacoteDao.excluir(id);
		pacotes = null;
		return "";
	}
	
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		pacote = pacoteDao.buscarPorId(id);
		return "";
	}

	public List<Pacote> getPacotes() {
		if(pacotes == null){
			pacotes = pacoteDao.listarTodos();
		}
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}
	
	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public PacoteDao getPacoteDao() {
		return pacoteDao;
	}

	public void setPacoteDao(PacoteDao pacoteDao) {
		this.pacoteDao = pacoteDao;
	}
	
}
