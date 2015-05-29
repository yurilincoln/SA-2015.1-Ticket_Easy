package br.senai.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.entity.QuantidadeDePontoTuristico;

public class QuantidadeDePontoTuristicoDao extends Dao {
	
	@SuppressWarnings("unchecked")
	public List<QuantidadeDePontoTuristico> listarTodos() {
		Query query = getEntityManager().createQuery("From QuantidadeDePontoTuristico", QuantidadeDePontoTuristico.class);
		return query.getResultList();
	}

	public QuantidadeDePontoTuristicoDao buscaPorId(Long id) {
		return getEntityManager().getReference(QuantidadeDePontoTuristicoDao.class, id);
	}
	
}
