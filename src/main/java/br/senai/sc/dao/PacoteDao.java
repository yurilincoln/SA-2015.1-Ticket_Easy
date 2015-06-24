package br.senai.sc.dao;

import java.util.List;

import br.senai.sc.entity.Pacote;


public class PacoteDao extends DaoImplements<Pacote>{

	public PacoteDao() {
		super(Pacote.class);
	}

	public void salvar(Pacote pacote) {
		save(pacote);
	}

	public List<Pacote> listarTodos() {
		return findAll();
	}

	public void excluir(Long id) {
		Pacote pacote = findAllById(id);
		delete(pacote);
	}

	public Pacote buscarPorId(Long id) {
		return findAllById(id);
	}

}