package br.senai.sc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.senai.sc.model.Pacote;

public class PacoteDao {

	private EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("ticketeasy");
	private EntityManager entityManager;

	public PacoteDao() {
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void salvar(Pacote pacote) {
		entityManager.getTransaction().begin();
		entityManager.persist(pacote);
		entityManager.getTransaction().commit();
	}

	public void excluir(Long id) {
		entityManager.getTransaction().begin();
		Pacote pacote = entityManager.getReference(Pacote.class, id);
		entityManager.remove(pacote);
		entityManager.getTransaction().commit();
	}

	// public Pacote buscarPorId(Long id) {
	// entityManager.getTransaction().begin();
	// Pacote pacote = entityManager.getReference(Pacote.class, id);
	// entityManager.getTransaction().commit();
	// return pacote;
	//
	// }

	public void atualizar(Pacote pacote) {
		entityManager.getTransaction().begin();
		entityManager.merge(pacote);
		entityManager.getTransaction().commit();
	}

	public List<Pacote> listar() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("From Pacote", Pacote.class);
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

	public void finalize() {
		entityManager.close();
		entityManagerFactory.close();
	}

}