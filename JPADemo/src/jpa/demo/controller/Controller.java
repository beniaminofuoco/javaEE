package jpa.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa.demo.entity.Libro;
import jpa.demo.entity.Utente;

public class Controller {

	private final EntityManagerFactory manager;
	
	public Controller() {
		this.manager = Persistence.createEntityManagerFactory("JPADemo");
	}
	
	public void aggiunteUtente(Utente utente) {
		EntityManager entityManager = this.manager.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(utente);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void aggiunteLibro(Utente utente, Libro libro) {
		EntityManager entityManager = this.manager.createEntityManager();
		utente.getLibri().add(libro);
		entityManager.getTransaction().begin();
		entityManager.merge(utente);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Utente> getUtenti(){
		List<Utente> result = new ArrayList<>();
		EntityManager entityManager = this.manager.createEntityManager();
		result=entityManager.createNamedQuery("Utente.getUtenti").getResultList();
		entityManager.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Utente> getUtentiCriteria(){
		List<Utente> result = new ArrayList<>();
		EntityManager entityManager = this.manager.createEntityManager();
		
		CriteriaQuery<Utente>  cq = entityManager.getCriteriaBuilder().createQuery(Utente.class);
		Root<Utente> root =  cq.from(Utente.class);
		cq.select(root);
		
		Query query = entityManager.createQuery(cq);
		result = query.getResultList();
		return result;
	}
	
	public List<Utente> getUtentiCriteriaWhere(String username){
		List<Utente> result = new ArrayList<>();
		EntityManager entityManager = this.manager.createEntityManager();
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Utente>  cq = entityManager.getCriteriaBuilder().createQuery(Utente.class);
		Root<Utente> root =  cq.from(Utente.class);
		cq.where(cb.equal(root.get("username"), username));
		
		Query query = entityManager.createQuery(cq);
		Utente pippo = (Utente)query.getSingleResult();
		result.add(pippo);
		return result;
	}
}
