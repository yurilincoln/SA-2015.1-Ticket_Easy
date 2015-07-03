package br.senai.sc.mb;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.senai.sc.dao.DestinoDao;
import br.senai.sc.dao.PacoteDao;
import br.senai.sc.dao.PedidoDao;
import br.senai.sc.entity.Destino;
import br.senai.sc.entity.Pacote;
import br.senai.sc.entity.Pedido;

@ManagedBean
public class PedidoMB {

	private PedidoDao pedidoDao;
	
	@ManagedProperty(value="#{sessaoMB}")
	private SessaoMB sessao;
	private DestinoDao destinoDao;
	private PacoteDao pacoteDao;
	
	@PostConstruct
	public void initMB(){
//		sessao = new SessaoMB();
		pedidoDao = new PedidoDao();
		destinoDao = new DestinoDao();
		pacoteDao = new PacoteDao();
	}
	
	public String adicionarDestino(String idDestino){
		Long id = Long.valueOf(idDestino);
		Destino destino = destinoDao.buscarPorId(id);
		if(sessao.getPedido() == null){
			sessao.setPedido(new Pedido());
		}
		sessao.getPedido().getDestinos().add(destino);
		return "";
	}

	public String adicionarPacote(String idPacote){
		Long id = Long.valueOf(idPacote);
		Pacote pacote = pacoteDao.buscarPorId(id);
		if(sessao.getPedido() == null){
			sessao.setPedido(new Pedido());
		}
		sessao.getPedido().getPacotes().add(pacote);
		return "carrinho";
	}

	public PedidoDao getPedidoDao() {
		return pedidoDao;
	}

	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}

	public DestinoDao getDestinoDao() {
		return destinoDao;
	}

	public void setDestinoDao(DestinoDao destinoDao) {
		this.destinoDao = destinoDao;
	}

	public SessaoMB getSessao() {
		return sessao;
	}

	public void setSessao(SessaoMB sessao) {
		this.sessao = sessao;
	}

	public PacoteDao getPacoteDao() {
		return pacoteDao;
	}

	public void setPacoteDao(PacoteDao pacoteDao) {
		this.pacoteDao = pacoteDao;
	}
	
	
	

	
	
}