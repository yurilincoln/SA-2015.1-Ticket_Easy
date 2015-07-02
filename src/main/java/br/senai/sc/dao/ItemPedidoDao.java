package br.senai.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.entity.ItemPedido;
import br.senai.sc.entity.Pacote;


public class ItemPedidoDao extends Dao {

	public void salvar(ItemPedido itemPedido) {
		getEntityManager().merge(itemPedido);
	}

	@SuppressWarnings("unchecked")
	public List<ItemPedido> listarTodos() {
		Query query = getEntityManager().createQuery("From ItemPedido",ItemPedido.class);
		return query.getResultList();
	}
	
	public void excluir(Long id) {
		ItemPedido itemPedido = getEntityManager().getReference(ItemPedido.class, id);
		getEntityManager().remove(itemPedido);
	}

	public ItemPedido buscarPorId(Long id) {
		return getEntityManager().find(ItemPedido.class, id);
	}
	

}