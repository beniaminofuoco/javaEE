package jpa.cascade.esempi;

import javax.persistence.EntityManager;

import jpa.cascade.entity.JPAExecutor;
import jpa.cascade.entity.Libro;
import jpa.cascade.entity.Utente;

/**
 * 
 * @author Fuoco Beniamino
 * 
 *         Eseguo l'esempio utilizzando CascadeType.PERSIST sulla relazione
 *         OneToMany nella classe Utente.
 * 
 *         Inizialmente(con solo PERSIST) una volta fatto il Detach dell'oggetto Utente
 *         l'oggetto Libro rimane del PC.
 *         
 *         Se invece, oltre che al PERSIST aggiungiamo ANCHE  DETACH dopo il detach sull'oggetto Utente
 *         anche l'oggetto Libro viene tolto dal PC.
 *         
 *
 */
public class Test4 extends JPAExecutor {

	@Override
	public void execute() {
		Libro libro = new Libro("GoT", "George RR Martin");

		Utente utente = new Utente("Beniamino", "b.fuoco@iol.it");
		utente.getLibri().add(libro);

		persist(utente);

		EntityManager em = createEntityManager();
		System.out.println("Punto 1: " + em.contains(utente));

		utente = em.merge(utente);
		libro = utente.getLibri().get(0);

		// Ritornano SEMPRE TRUE
		System.out.println("Punto 2 Utente: " + em.contains(utente));
		System.out.println("Punto 2 Libro: " + em.contains(libro));

		em.detach(utente);

		// Viene sempre fatto DETACH -> Ritorna FALSE
		System.out.println("Punto 3 Utente: " + em.contains(utente));
		// Con CascadeType.PERSIST --> Ritorna TRUE
		// Con {CascadeTye.PERSIST, CascadeType.DETACH} --> Ritorna FALSE
		System.out.println("Punto 3 Libro: " + em.contains(libro));

		em.close();
	}

	public static void main(String[] args) {
		Test4 test = new Test4();
		test.execute();
	}
}
