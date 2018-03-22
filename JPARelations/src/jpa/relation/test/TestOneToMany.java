package jpa.relation.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.relation.entity.IndirizzoOneToMany;
import jpa.relation.entity.UtenteOneToMany;

public class TestOneToMany {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPARelations");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		UtenteOneToMany utente = new UtenteOneToMany("Beniamino");
		em.persist(utente);

		IndirizzoOneToMany indirizzo = new IndirizzoOneToMany();
		indirizzo.setCitta("Torino");
		indirizzo.setVia("Via Bibiana, 33");
		indirizzo.setUtente(utente);
		em.persist(indirizzo);

		IndirizzoOneToMany indirizzo2 = new IndirizzoOneToMany();
		indirizzo2.setCitta("Sersale");
		indirizzo2.setVia("Via Sila, 1");
		indirizzo2.setUtente(utente);
		em.persist(indirizzo2);

		em.getTransaction().commit();

		em.refresh(utente);

		for (IndirizzoOneToMany ind : utente.getIndirizzi()) {
			System.out.println("Città : " + ind.getCitta() + " Via: " + ind.getVia() + " Utente: "
					+ ind.getUtente().getUsername());
		}

		em.close();
		emf.close();

	}

}
