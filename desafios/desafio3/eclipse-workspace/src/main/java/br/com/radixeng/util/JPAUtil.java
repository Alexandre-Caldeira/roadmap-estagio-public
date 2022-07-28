package br.com.radixeng.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("adventureworks");

	public static EntityManager getEntityManager() { 
		return FACTORY.createEntityManager();
	}
	
}
