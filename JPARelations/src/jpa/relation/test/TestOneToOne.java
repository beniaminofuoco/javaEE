package jpa.relation.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.relation.entity.Indirizzo;
import jpa.relation.entity.Utente;

public class TestOneToOne {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPARelations");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Utente utente = new Utente("Beniamino");
		
		Indirizzo indirizzo = new Indirizzo();
		indirizzo.setCitta("Torino");
		indirizzo.setVia("Via Bibiana, 33");
		
		utente.setIndirizzo(indirizzo);
		
		em.persist(utente);
		em.getTransaction().commit();
		em.refresh(indirizzo);
		
		System.out.println(indirizzo.getUtente().getUsername());
		
		em.close();
		emf.close();
	}

}
