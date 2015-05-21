package br.senai.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.entity.Contato;
import br.senai.sc.entity.Pacote;

public class ContatoDao extends Dao {

	public void salvar(Contato contato) {
		getEntityManager().merge(contato);
	}
	
	public void excluir(Long id) {
		Contato contato = getEntityManager().getReference(Contato.class, id);
		getEntityManager().remove(contato);
	}

	 public Pacote buscarPorId(Long id) {
	 getEntityManager().getTransaction().begin();
	 Pacote pacote = getEntityManager().getReference(Pacote.class, id);
	 getEntityManager().getTransaction().commit();
	 return pacote;
	
	 }

	public void atualizar(Contato contato) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(contato);
		getEntityManager().getTransaction().commit();
	}

	public List<Contato> listar() {
		 getEntityManager().getTransaction().begin();
		Query query = getEntityManager().createQuery("From Contato", Pacote.class);
		 getEntityManager().getTransaction().commit();
		return query.getResultList();
	}

	public void finalize() {
		 getEntityManager().close();
		 getEntityManager().close();
	}
}
