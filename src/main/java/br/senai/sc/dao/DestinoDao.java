package br.senai.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.entity.Destino;


public class DestinoDao extends Dao {

	public void salvar(Destino destino) {
		getEntityManager().merge(destino);
	}

	@SuppressWarnings("unchecked")
	public List<Destino> listarTodos() {
		Query query = getEntityManager().createQuery("From Destino",Destino.class);
		return query.getResultList();
	}
	
	public void excluir(Long id) {
		Destino destino = getEntityManager().getReference(Destino.class, id);
		getEntityManager().remove(destino);
	}

	public Destino buscarPorId(Long id) {
		return getEntityManager().find(Destino.class, id);
	}

//	public void atualizar(Destino pacote) {
//		getEntityManager().getTransaction().begin();
//		getEntityManager().merge(pacote);
//		getEntityManager().getTransaction().commit();
//	}
//
//	public void finalize() {
//		 getEntityManager().close();
//		 getEntityManager().close();
//	}

}