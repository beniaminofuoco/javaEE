package jpa.relation.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: UtenteOneToMany
 *
 */
@Entity
public class UtenteOneToMany implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;

	/**
	 * Quando utilizziamo una relazione 1-to-Many(quindi con una lista di indirizzi).
	 * In questo caso dobbiamo andare a specificare il campo che mappa la relazione 
	 * all'interno della classe Indirizzo(utente).
	 * 
	 */
	@OneToMany(mappedBy="utente")
	private List<IndirizzoOneToMany> indirizzi;

	public UtenteOneToMany() {
		this.indirizzi = new ArrayList<>();
	}

	public UtenteOneToMany(String username) {
		this();
		this.username = username;
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

	public List<IndirizzoOneToMany> getIndirizzi() {
		return indirizzi;
	}

	public void setIndirizzi(List<IndirizzoOneToMany> indirizzi) {
		this.indirizzi = indirizzi;
	}
}
