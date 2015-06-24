package br.senai.sc.dao;

import java.util.List;

import br.senai.sc.entity.Administrador;

public class AdministradorDao extends DaoImplements<Administrador> {
	
	public AdministradorDao() {
		super(Administrador.class);
	}

	public void salvar(Administrador administrador) {
		save(administrador);
	}

	public List<Administrador> listarTodos() {
		return findAll();
	}

	public void excluir(Long id) {
		Administrador administrador = findAllById(id);
		delete(administrador);
	}

	public Administrador buscarPorId(Long id) {
		return findAllById(id);
	}
	
	public Administrador buscaPorEmail(String email) {
//		Query query = getEntityManager().createQuery("From Usuario u Where u.email = :email", Usuario.class);
//		query.setParameter("email", nome);
		return findAllByEmail(email);
	}
}
