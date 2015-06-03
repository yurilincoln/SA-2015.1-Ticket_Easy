package br.senai.sc.dao;

import java.util.List;

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
	}
	
	public void excluir(Destino destino) {
		if (destino.getId() != null) {
			delete(destino);
	}
	}
	
	public List<Destino> listarTodos(Destino destino){
		return findAll();
		}

	public Destino buscaPorId(Long id){
		return findAllById(id);
	}
//	
//	public void excluir(Long id) {
//		Destino destino = getEntityManager().getReference(Destino.class, id);
//		getEntityManager().remove(destino);
//	}
//
//	public Destino buscarPorId(Long id) {
//		return getEntityManager().find(Destino.class, id);
//	}

	public Object buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
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