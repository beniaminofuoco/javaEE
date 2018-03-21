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
 *         Se avessimo messo CascadeType.PERSIST saremmo andati ad inserire un
 *         Utente con il relativo Libro, ma dopo la Remove il Libro sarebbe
 *         rimasto salvato a DB. Per ovviare a ciò basta aggiungere l'attributo
 *         -> orphanRemoval=true che va rimuovere tutti gli oggetti rimasti
 *         "ORFANI".
 * 
 *         L'attributo orphanRemoval=true è molto potente, in quanto rimuove
 *         tutti gli oggetti ORFANI quando si effettua il REMOVE oppure rimuove
 *         tutte le relazioni fra i vari oggetti (Es. ripulisce la tabella
 *         utente_libro che determina la relazione fra i due ID).
 *
 */
public class Test5 extends JPAExecutor {

	@Override
	public void execute() {
		Libro libro = new Libro("GoT", "George RR Martin");

		Utente utente = new Utente("Beniamino", "b.fuoco@iol.it");
		utente.getLibri().add(libro);

		// Per fare sia PERSIT che REMOVE aggiungiamo
		// nella classe Utente CascadeType.ALL
		persist(utente);
		remove(utente);
	}

	public static void main(String[] args) {
		Test5 test = new Test5();
		test.execute();
	}
}
