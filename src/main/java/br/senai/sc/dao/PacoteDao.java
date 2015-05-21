package br.senai.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.entity.Pacote;

public class PacoteDao extends Dao {

	public void salvar(Pacote pacote) {
		getEntityManager().merge(pacote);
	}

	public void excluir(Long id) {
		Pacote pacote = getEntityManager().getReference(Pacote.class, id);
		getEntityManager().remove(pacote);
	}

	 public Pacote buscarPorId(Long id) {
	 getEntityManager().getTransaction().begin();
	 Pacote pacote = getEntityManager().getReference(Pacote.class, id);
	 getEntityManager().getTransaction().commit();
	 return pacote;
	
	 }

	public void atualizar(Pacote pacote) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(pacote);
		getEntityManager().getTransaction().commit();
	}

	public List<Pacote> listar() {
		 getEntityManager().getTransaction().begin();
		Query query = getEntityManager().createQuery("From Pacote", Pacote.class);
		 getEntityManager().getTransaction().commit();
		return query.getResultList();
	}

	public void finalize() {
		 getEntityManager().close();
		 getEntityManager().close();
	}

}