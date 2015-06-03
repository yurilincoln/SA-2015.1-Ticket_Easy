package br.senai.sc.util;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequest;

public class JPAUtil {
	
	
	private static final String SA_2015_TEST = "ticketEasy_puTest";
	private static final String SA_2015 = "ticketEasy_pu";
	private static final String ENTITY_MANAGER = "ENTITY_MANAGER";
	public static EntityManagerFactory entityManagerFactory;

	public static EntityManager getEntityManager() throws Exception {
		String managerFactoryInUse = entityManagerFactory.getProperties().get("hibernate.ejb.persistenceUnitName").toString();
		
		if (SA_2015_TEST.equalsIgnoreCase(managerFactoryInUse)) {
			return createEntityManager();
		} else if(SA_2015.equalsIgnoreCase(managerFactoryInUse)) {
			ServletRequest request = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			return (EntityManager) request.getAttribute(ENTITY_MANAGER);
		} else {
			throw new Exception("Não foi possível localizar o entityManagerFactory em uso.");
		}
	}
	
	static EntityManager createEntityManager() {
		return createEntityManager(null);
	}

	static EntityManager createEntityManager(ServletRequest request) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		if (request != null) {
			request.setAttribute(ENTITY_MANAGER, entityManager);
			return entityManager;
		}
		return entityManager;
		
	}

	public static void createEntityManagerFactory(String persistenceUnit) {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);		
		}
	}
	
	public static void createEntityManagerFactory() {
		createEntityManagerFactory("ticketEasy_pu");
	}

	public static void entityManagerFactoryClose() {
		entityManagerFactory.close();
	}

//	private static final String ENTITY_MANAGER = "ENTITY_MANAGER";
//	private static EntityManagerFactory entityManagerFactory;
//
//	public static EntityManager getEntityManager() {
//		ServletRequest request = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//		return (EntityManager) request.getAttribute(ENTITY_MANAGER);
//	}
//
//	static EntityManager createEntityManager(ServletRequest request) {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
//		request.setAttribute(ENTITY_MANAGER, entityManager);
//		
//		return entityManager;
//	}
//
//	static void creteEntityManagerFactory() {
//		entityManagerFactory = Persistence.createEntityManagerFactory("ticketeasy_pu");		
//	}
//
//	static void entityManagerFactoryClose() {
//		entityManagerFactory.close();
//	}

}
