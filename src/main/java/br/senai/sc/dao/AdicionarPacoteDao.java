package br.senai.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.entity.Destino;

public class AdicionarPacoteDao extends Dao {

	@SuppressWarnings("unchecked")
	public List<Destino> listarTodos() {
		Query query = getEntityManager().createQuery("From Destino",
				Destino.class);
		return query.getResultList();
	}

	public Destino buscaPorId(Long id) {
		return getEntityManager().getReference(Destino.class, id);
	}
	
}
