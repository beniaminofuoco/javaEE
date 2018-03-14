package jse.demo.jaxb;

import java.io.StringWriter;

import javax.xml.bind.JAXB;

public class TestJaxb {

	public static void main(String[] args) {
		Utente utente = new Utente();
		utente.setNome("Bonti");
		utente.setEmail("bonti@iol.it");
		
		Libro book1 = new Libro();
		book1.setAutore("Benjamin");
		book1.setTitolo("Il Curioso caso");
		utente.getLibri().add(book1);
		
		Libro book2 = new Libro();
		book2.setAutore("Fire");
		book2.setTitolo("Gioco con il Fuoco");
		utente.getLibri().add(book2);

		StringWriter sw = new StringWriter();
		JAXB.marshal(utente, sw);
		System.out.println(sw.toString());
		
	}
}
