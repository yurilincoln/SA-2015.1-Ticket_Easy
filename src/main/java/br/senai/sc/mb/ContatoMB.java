package br.senai.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.dao.ContatoDao;
import br.senai.sc.entity.Contato;

@ManagedBean
public class ContatoMB {
	
	private Contato contato;
	private List<Contato> contatos;
	private ContatoDao contatoDao;
	
	@PostConstruct
	public void initMB(){
		this.contato = new Contato();
		contatoDao = new ContatoDao();
	}
	
	public ContatoMB() {
		contato = new Contato();
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	
 	public String salvar(){
 		ContatoDao dao = new ContatoDao();
		dao.salvar(contato);
		contato = new Contato();
		return "";
 	}
 	
 	public List<Contato> getContatos() {
 		ContatoDao dao = new ContatoDao();
		if(contatos == null){
			contatos = dao.listarTodos();
		}
		return contatos;
	}
	
 	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		contatoDao.excluir(id);
		contatos = null;
		return "";
	}
}