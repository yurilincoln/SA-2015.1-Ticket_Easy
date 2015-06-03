package br.senai.sc.configuration;

import br.senai.sc.util.JPAUtil;


public class EntityManagerTestLoader {


	private static final String SA_2015_TEST = "ticketEasy_puTest";

	public static void load() {
		JPAUtil.createEntityManagerFactory(SA_2015_TEST);
	}
}
