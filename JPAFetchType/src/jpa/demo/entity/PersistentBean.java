package jpa.demo.entity;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

@RequestScoped
public class PersistentBean {

	@PersistenceContext
	private EntityManager em;
	
	public Utente getUtente() {
		CriteriaQuery<Utente> cq = em.getCriteriaBuilder().createQuery(Utente.class);
		cq.from(Utente.class);
		Query query = em.createQuery(cq);
		
		return (Utente)query.getResultList().get(0);
	}
}
