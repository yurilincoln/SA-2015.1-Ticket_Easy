//package br.senai.sc.dao;
//
//import java.util.List;
//
//import br.senai.sc.entity.Contato;
//
//
//public class ContatoDao_Test extends DaoImplements<Contato> {
//
//	public ContatoDao_Test() {
//		super(Contato.class);
//	}
//
//	public void salvar(Contato contato) {
//		save(contato);
//	}
//
//	public List<Contato> listarTodos() {
//		return findAll();
//	}
//
//	public void excluir(Long id) {
//		Contato contato = findAllById(id);
//		delete(contato);
//	}
//
//	public Contato buscarPorId(Long id) {
//		return findAllById(id);
//	}
//}