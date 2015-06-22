package br.senai.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.entity.Administrador;

public class AdministradorDao extends Dao {
	
	public void cadastrar(Administrador administrador) {
		getEntityManager().merge(administrador);
	}

	@SuppressWarnings("unchecked")
	public List<Administrador> listarTodos() {
		Query query = getEntityManager().createQuery("From Administrador",Administrador.class);
		return query.getResultList();
	}
	
	public void excluir(Long id) {
		Administrador administrador = getEntityManager().getReference(Administrador.class, id);
		getEntityManager().remove(administrador);
	}

	public Administrador buscarPorId(Long id) {
		return getEntityManager().find(Administrador.class, id);
	}
	
	public Administrador buscaPorEmail(String nome) {
		Query query = getEntityManager().createQuery("From Administrador u Where u.email = :email", Administrador.class);
		query.setParameter("email", nome);
		return (Administrador) query.getSingleResult();
	}
}
