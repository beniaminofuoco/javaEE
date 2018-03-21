package jpa.cascade.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JPAExecutor {

	private final EntityManagerFactory emf;

	public JPAExecutor() {
		this.emf = Persistence.createEntityManagerFactory("JPACascade");
	}

	protected EntityManager createEntityManager() {
		return this.emf.createEntityManager();
	}
	
	protected void persist(Object entity) {
		EntityManager em = startTransaction();
		em.persist(entity);
		closeTransaction(em);
	}
	
	protected void merge(Object entity) {
		EntityManager em = startTransaction();
		em.merge(entity);
		closeTransaction(em);
	}
	
	protected void remove(Object entity) {
		EntityManager em = startTransaction();
		// Il metodo viene richiamato per rendere 
		// la Entity -> Managed
		em.remove(em.merge(entity));
		closeTransaction(em);
	}
	
	private EntityManager startTransaction() {
		EntityManager em = createEntityManager();
		em.getTransaction().begin();
		return em;
	}
	
	private void closeTransaction(EntityManager em) {
		em.getTransaction().commit();
		em.close();
	}
	
	public abstract void execute();
}
