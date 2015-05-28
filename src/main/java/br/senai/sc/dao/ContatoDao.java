package br.senai.sc.dao;

import br.senai.sc.entity.Contato;
import br.senai.sc.entity.Destino;

public class ContatoDao extends Dao {

	public void salvar(Contato contato) {
		getEntityManager().merge(contato);
	}
	
	public void excluir(Long id) {
		Contato contato = getEntityManager().getReference(Contato.class, id);
		getEntityManager().remove(contato);
	}

	 public Destino buscarPorId(Long id) {
	 getEntityManager().getTransaction().begin();
	 Destino destino = getEntityManager().getReference(Destino.class, id);
	 getEntityManager().getTransaction().commit();
	 return destino;
	
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

	public void finalize() {
		 getEntityManager().close();
		 getEntityManager().close();
	}
}
