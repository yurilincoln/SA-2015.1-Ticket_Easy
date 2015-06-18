package br.senai.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.entity.Usuario;

public class UsuarioDao extends Dao {
	
	public void cadastrar(Usuario usuario) {
		getEntityManager().merge(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos() {
		Query query = getEntityManager().createQuery("From Usuario",Usuario.class);
		return query.getResultList();
	}
	
	public void excluir(Long id) {
		Usuario usuario = getEntityManager().getReference(Usuario.class, id);
		getEntityManager().remove(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return getEntityManager().find(Usuario.class, id);
	}
	
	public Usuario buscaPorEmail(String nome) {
		Query query = getEntityManager().createQuery("From Usuario u Where u.email = :email", Usuario.class);
		query.setParameter("email", nome);
		return (Usuario) query.getSingleResult();
	}
}
