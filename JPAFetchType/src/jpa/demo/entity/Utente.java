package jpa.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Il FetchType.LAZY non carica tutti i Libri associati all'utente,
 * questo perchè se un Utente a 10000 Libri le prestazioni ne risentirebbero.
 * 
 * Il FetchType.EAGER carica tutti i Libri dell'utente
 * nel momento in cui viene caricato l'utente.
 * 
 * IMP-> l'attributo Fetch è da utilizzare solo sulle Liste e bisogna fare attenzione
 * a non SERIALIZZARE/DESERIALIZZARE i dati prima che tutti i dati vengano caricati
 * altrimenti si avrà un eccezzione.
 */
@Entity
public class Utente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Libro> libri;

	public Utente() {
		this.libri = new ArrayList<>();
	}

	public Utente(String username, String email) {
		this();
		this.username = username;
		this.email = email;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}
   
}
