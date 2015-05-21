package br.senai.sc.mb;

import br.senai.sc.dao.PacoteDao;
import br.senai.sc.entity.Pacote;

public class PacoteMB {

	private Pacote pacote;
	
	public PacoteMB() {
		pacote = new Pacote();
	}

	public String enviar(){
		PacoteDao dao = new PacoteDao();
		dao.salvar(pacote);
		pacote = new Pacote();
		return "";
	}
	
	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	
}
