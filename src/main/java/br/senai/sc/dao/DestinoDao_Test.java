//package br.senai.sc.dao;
//
//import java.util.List;
//
//import br.senai.sc.entity.Destino;
//
//
//public class DestinoDao_Test extends DaoImplements<Destino> {
//
//	public DestinoDao_Test() {
//		super(Destino.class);
//	}
//
//	public void salvar(Destino destino) {
//		save(destino);
//	}
//
//	public List<Destino> listarTodos() {
//		return findAll();
//	}
//
//	public void excluir(Long id) {
//		Destino destino = findAllById(id);
//		delete(destino);
//	}
//
//	public Destino buscarPorId(Long id) {
//		return findAllById(id);
//	}
//
//}