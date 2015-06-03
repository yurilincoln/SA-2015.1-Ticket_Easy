package br.senai.sc.dao;

import br.senai.sc.entity.Destino;


public class DestinoDao extends DaoImplements<Destino> {

	public DestinoDao(Class<Destino> klass) {
		super(Destino.class);
	}

	public void salvar(Destino destino) {
		if (destino.getId() == null) {
			save(destino);
		} else {
			update(destino);
		}
//		getEntityManager().merge(destino);
	}

//	@SuppressWarnings("unchecked")
//	public List<Destino> listarTodos() {
//		Query query = getEntityManager().createQuery("From Destino",Destino.class);
//		return query.getResultList();
//	}
//	
//	public void excluir(Long id) {
//		Destino destino = getEntityManager().getReference(Destino.class, id);
//		getEntityManager().remove(destino);
//	}
//
//	public Destino buscarPorId(Long id) {
//		return getEntityManager().find(Destino.class, id);
//	}

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