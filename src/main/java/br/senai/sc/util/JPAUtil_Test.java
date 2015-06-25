//package br.senai.sc.util;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class JPAUtil_Test {
//	
//	private static final String SA_2015 = "ticketeasy_pu";
//	public static EntityManagerFactory entityManagerFactory;
//
//	public static EntityManager createEntityManager() {
//		return entityManagerFactory.createEntityManager();
//	}
//
//	public static void createEntityManagerFactory(String persistenceUnit) {
//		if (entityManagerFactory == null) {
//			entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
//		}
//	}
//
//	public static void createEntityManagerFactory() {
//		createEntityManagerFactory(SA_2015);
//	}
//
//	public static void entityManagerFactoryClose() {
//		entityManagerFactory.close();
//	}
//
//}
