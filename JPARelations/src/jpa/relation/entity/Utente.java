package jpa.relation.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Utente
 *
 */
@Entity
public class Utente implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	
	/**
	 * Quando utilizziamo una relazione 1-to-1
	 * (cioè un Utente può avere 1 indirizz0)
	 * specifico anche il nome della colonna che 
	 * identificherà il singolo indirizzo
	 */
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_indirizzo")
	private Indirizzo indirizzo;

	public Utente() {
		super();
	}   
	
	public Utente(String username) {
		this();
		this.username=username;
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

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
}
