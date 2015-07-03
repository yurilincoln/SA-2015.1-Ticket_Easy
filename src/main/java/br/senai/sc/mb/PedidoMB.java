package br.senai.sc.mb;


import java.util.List;

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
	private Pedido pedido;
	private List<Destino> destinos;
	
	@PostConstruct
	public void initMB(){
//		sessao = new SessaoMB();
		this.pedido = new Pedido();
		pedidoDao = new PedidoDao();
		destinoDao = new DestinoDao();
		pacoteDao = new PacoteDao();
	}
	
	
	
	public String adicionarDestino(String idDestino){
		Long id = Long.valueOf(idDestino);
		Destino destino = destinoDao.buscarPorId(id);
		if(pedido.getDestinos() == null){
			pedido.setDestinos(destinos);
		}
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Destino> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}
	
}