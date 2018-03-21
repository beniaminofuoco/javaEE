package jpa.cascade.esempi;

import jpa.cascade.entity.JPAExecutor;
import jpa.cascade.entity.Libro;
import jpa.cascade.entity.Utente;

/**
 * 
 * @author Fuoco Beniamino
 * 
 *         Eseguo l'esempio utilizzando CascadeType.ALL sulla relazione
 *         OneToMany nella classe Utente.
 * 
 *         L'idea � quella di creare un libro ed associarlo a pi� utenti, ma con
 *         il CascadeType.ALL non funziona in quanto JPA cerca di associare lo
 *         stesso ID(del Libro) a pi� utenti.
 * 
 *         Per ovviare a ci� si sostituisce CascadeType.ALL con MERGE e si
 *         AGGIUNGE il persist del Libro e poi dei relativi Utenti.
 *
 */
public class Test2 extends JPAExecutor {

	@Override
	public void execute() {
		Libro libro = new Libro("GoT", "George RR Martin");
		persist(libro);
		
		Utente utente1 = new Utente("Beniamino", "b.fuoco@iol.it");
		Utente utente2 = new Utente("Benjamin", "ben.fuoco@iol.it");

		utente1.getLibri().add(libro);
		persist(utente1);

		utente2.getLibri().add(libro);
		persist(utente2);

	}

	public static void main(String[] args) {
		Test2 test = new Test2();
		test.execute();
	}
}
