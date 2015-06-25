package br.senai.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.entity.Contato;


public class ContatoDao extends Dao {

	public void salvar(Contato contato) {
		getEntityManager().merge(contato);
	}

	@SuppressWarnings("unchecked")
	public List<Contato> listarTodos() {
		Query query = getEntityManager().createQuery("From Contato",Contato.class);
		return query.getResultList();
	}
	
	public void excluir(Long id) {
		Contato contato = getEntityManager().getReference(Contato.class, id);
		getEntityManager().remove(contato);
	}

	public Contato buscarPorId(Long id) {
		return getEntityManager().find(Contato.class, id);
	}

//	public void atualizar(Contato contato) {
//		getEntityManager().getTransaction().begin();
//		getEntityManager().merge(contato);
//		getEntityManager().getTransaction().commit();
//	}

//	public List<Contato> listar() {
//		 getEntityManager().getTransaction().begin();
//		Query query = getEntityManager().createQuery("From Contato", Destino.class);
//		 getEntityManager().getTransaction().commit();
//		return query.getResultList();
//	}

//	public void finalize() {
//		 getEntityManager().close();
//		 getEntityManager().close();
//	}
}