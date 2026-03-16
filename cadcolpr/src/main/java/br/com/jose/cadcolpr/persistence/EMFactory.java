package br.com.jose.cadcolpr.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFactory {

	private static EntityManager em;

	public static EntityManager getEm() {

		if (em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadcolPU");
			em = factory.createEntityManager();
		}
		return em;
	}

}
