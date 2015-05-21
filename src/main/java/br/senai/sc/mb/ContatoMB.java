package br.senai.sc.mb;

import javax.faces.bean.ManagedBean;

import br.senai.sc.dao.ContatoDao;
import br.senai.sc.entity.Contato;

@ManagedBean
public class ContatoMB {
	
	private Contato contato;
	

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public ContatoMB() {
		contato = new Contato();
	}
	
 	public String enviar(){
 		ContatoDao dao = new ContatoDao();
		dao.salvar(contato);
		contato = new Contato();
		return "";
 	}
	
}
