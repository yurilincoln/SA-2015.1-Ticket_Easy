//package br.senai.sc.dao;
//
//import java.util.List;
//
//import javax.persistence.Query;
//
//import br.senai.sc.entity.Pacote;
//
//
//public class PacoteDao extends Dao {
//
//	public void salvar(Pacote pacote) {
//		getEntityManager().merge(pacote);
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Pacote> listarTodos() {
//		Query query = getEntityManager().createQuery("From Pacote",Pacote.class);
//		return query.getResultList();
//	}
//	
//	public void excluir(Long id) {
//		Pacote pacote = getEntityManager().getReference(Pacote.class, id);
//		getEntityManager().remove(pacote);
//	}
//
//	public Pacote buscarPorId(Long id) {
//		return getEntityManager().find(Pacote.class, id);
//	}
//
////	public void atualizar(Pacote pacote) {
////		getEntityManager().getTransaction().begin();
////		getEntityManager().merge(pacote);
////		getEntityManager().getTransaction().commit();
////	}
////
////	public void finalize() {
////		 getEntityManager().close();
////		 getEntityManager().close();
////	}
//
//}