package br.senai.sc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.senai.sc.dao.PacoteDaoImp;
import br.senai.sc.model.Pacote;


public class Main {

	public static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("imobiliariaPu");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	private static void cadastrarPacote(EntityManager entityManager) {
		PacoteDaoImp pacoteDaoImp = entityManager.getReference(PacoteDaoImp.class, 1L);
		Pacote pacote;
		pacote = new Pacote();
		pacote.setNome("Maracanã");
		pacote.setCidade("Rio de Janeiro");
		pacote.setEstado("Rio de Janeiro");
		pacote.setBairro("Zona Norte");
		pacote.setDescricao("O Estádio do Maracanã foi constuído em 1950 para a C"
				+ "opa do Mundo do mesmo ano, "
				+ "e projetado para receber 166.369 espectadores. "
				+ "Atualmente após reformas, está apto a receber uma platéia de"
				+ " 114.145 assistentes");
		pacote.setHoraFuncionamento("Dás 10:00hrs até ás 19:00");
		pacote.setValor(120.0);
		pacote.setObersevacoes("O preço para a visita de moradores locais é de R$80!!");
		((PacoteDaoImp) entityManager).salvar(pacote);
		
	}

	private static void listar(EntityManager entityManager) {
		Query query = entityManager.createQuery("From PacoteDaoImp", Pacote.class);
		List<Pacote> pacotes = query.getResultList();
		
		System.out.println("Lista de Imóveis Cadastrados:");
		for (Pacote pacote : pacotes) {
			System.out.println("Nome: " + pacote.getNome());
			System.out.println("Estádo: " + pacote.getEstado());
			System.out.println("Estádo: " + pacote.getCidade());
			System.out.println("Valor da Entrada: " + pacote.getValor() + " reais.");
			System.out.println("=-=-=-==-=-=-==-=-=-==-=-=-==-=-=-==-=-=-=");
		}
	}
	
	private static void atualizar(EntityManager entityManager) {
		Pacote pacote;
		pacote = new Pacote();
		pacote.setId(1L);
		pacote.setNome("Bondinho");
		pacote.setCidade("Rio de Janeiro");
		pacote.setEstado("Rio de Janeiro");
		pacote.setBairro("Zona Norte");
		pacote.setDescricao("Bondinho do Rio de Janeiro");
		pacote.setHoraFuncionamento("Dás 13:00hrs até ás 18:00");
		pacote.setValor(150.0);
		pacote.setObersevacoes("O preço para a visita de moradores locais é o mesmo!!");
		// corrigir entityManager.atualizar(pacote);
	}

	private static void excluir(EntityManager entityManager) {
		Pacote pacote = entityManager.getReference(Pacote.class, 2L);
		// corrigir entityManager.excluir(pacote);
	}

}
