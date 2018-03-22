package jpa.relation.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.relation.entity.IndirizzoOTM_JT;
import jpa.relation.entity.UtenteOTM_JT;

public class TestOTM_JT {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPARelations");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		IndirizzoOTM_JT ind1 = new IndirizzoOTM_JT();
		ind1.setCitta("Torino");
		ind1.setVia("Via Bibiana, 33");
		em.persist(ind1);
		
		IndirizzoOTM_JT ind2 = new IndirizzoOTM_JT();
		ind2.setCitta("Sersale");
		ind2.setVia("Via Sila, 1");
		em.persist(ind2);
		
		UtenteOTM_JT utente = new UtenteOTM_JT("Beniamino");
		em.persist(utente);
		
		utente.getIndirizzi().add(ind1);
		utente.getIndirizzi().add(ind2);
		em.merge(utente);
		
		em.getTransaction().commit();
		
		em.refresh(ind1);
		em.refresh(ind2);
		
		System.out.println(ind1.getUtente().getUsername());
		System.out.println(ind2.getUtente().getUsername());

		em.close();
		emf.close();

	}

}
