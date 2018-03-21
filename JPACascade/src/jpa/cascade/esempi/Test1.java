package jpa.cascade.esempi;

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
 */
public class Test1 extends JPAExecutor {

	@Override
	public void execute() {
		Libro libro = new Libro("GoT", "George RR Martin");

		Utente utente = new Utente("Beniamino", "b.fuoco@iol.it");
		utente.getLibri().add(libro);

		persist(utente);
		// La notazione CascadeType.PERSIST nella classe Utente
		// ci ha permesso di salvare in automatico l'utente e il rilativo Libro
		// senza dover fare prima la Persist sull'oggetto Libro e successivamente
		// quella sull'oggetto Utente.
	}

	public static void main(String[] args) {
		Test1 test = new Test1();
		test.execute();
	}
}
