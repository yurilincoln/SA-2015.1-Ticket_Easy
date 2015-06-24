package br.senai.sc.dao;

import java.util.List;

import br.senai.sc.entity.Usuario;

public class UsuarioDao extends DaoImplements<Usuario> {
	
	public UsuarioDao() {
		super(Usuario.class);
	}

	public void salvar(Usuario usuario) {
		save(usuario);
	}

	public List<Usuario> listarTodos() {
		return findAll();
	}

	public void excluir(Long id) {
		Usuario usuario = findAllById(id);
		delete(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return findAllById(id);
	}
	
	public Usuario buscaPorEmail(String email) {
//		Query query = getEntityManager().createQuery("From Usuario u Where u.email = :email", Usuario.class);
//		query.setParameter("email", nome);
		return findAllByEmail(email);
	}
}
