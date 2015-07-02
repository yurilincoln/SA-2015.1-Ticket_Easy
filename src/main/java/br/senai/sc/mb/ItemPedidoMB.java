package br.senai.sc.mb;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.dao.DestinoDao;
import br.senai.sc.dao.ItemPedidoDao;
import br.senai.sc.dao.PacoteDao;
import br.senai.sc.entity.ItemPedido;

@ManagedBean
public class ItemPedidoMB {

	private ItemPedido itemPedido;
	private List<ItemPedido> itens;
	private ItemPedidoDao itemPedidoDao;
	private DestinoDao destinoDao;
	private PacoteDao pacoteDao;
	
	
	@PostConstruct
	public void initMB(){
		this.itemPedido = new ItemPedido();
		itemPedidoDao = new ItemPedidoDao();
	}
	
//	public String adicionaDestinoCarrinho(Long id){
//		itemPedido.getDestinos().add(destinoDao.buscarPorId(id));
//		return "carrinho?faces-redirect=true";
//	}
//	
//	public String adicionaPacoteCarrinho(Long id){
//		itemPedido.getPacotes().add(pacoteDao.buscarPorId(id));
//		return "carrinho?faces-redirect=true";
//	}
//	
//	public String excluir(String idParam){
//	}
//	
//	
//	public String editar(String idParam){
//	}
//	
	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	public List<ItemPedido> getItens() {
		if(itens == null){
			itens = itemPedidoDao.listarTodos();
		}
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public ItemPedidoDao getItemPedidoDao() {
		return itemPedidoDao;
	}

	public void setItemPedidoDao(ItemPedidoDao itemPedidoDao) {
		this.itemPedidoDao = itemPedidoDao;
	}
	
	
	
}