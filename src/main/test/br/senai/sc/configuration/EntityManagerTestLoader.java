package br.senai.sc.configuration;

import br.senai.sc.util.JPAUtil_Test;


public class EntityManagerTestLoader {


	private static final String SA_2015_TEST = "ticketeasy_puTest";

	public static void load() {
		JPAUtil_Test.createEntityManagerFactory(SA_2015_TEST);
	}
}
