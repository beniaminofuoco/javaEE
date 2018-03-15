package jpa.demo.test;

import java.util.List;

import jpa.demo.controller.Controller;
import jpa.demo.entity.Libro;
import jpa.demo.entity.Utente;

public class TestDemoJPA {

	public static void main(String[] args) {
		Controller contr = new Controller();
		creaUtentiConLibro(contr);
		getUtenti(contr);
	}

	private static void getUtenti(Controller contr) {
		List<Utente> utenti = contr.getUtenti();
		System.out.println("Il numero di utenti trovati e': "+utenti.size());
		for(Utente user : utenti) {
			System.out.println(user.getUsername());
		}
	}

	private static void creaUtentiConLibro(Controller contr) {
		Utente ute1 = new Utente();
		ute1.setUsername("pippo");
		ute1.setEmail("pippo@iol.it");
		Utente ute2 = new Utente();
		ute2.setUsername("pluto");
		ute2.setEmail("pluto@iol.it");
		
		Libro libro1 = new Libro();
		libro1.setAutore("Bonti");
		libro1.setTitolo("Bonti Man");
		
		Libro libro2 = new Libro();
		libro2.setAutore("Chiara");
		libro2.setTitolo("Chiaretta");

		contr.aggiunteLibro(ute1, libro1);
		contr.aggiunteLibro(ute2, libro2);
	}
}
