package jpa.cascade.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Utente
 *
 */
@Entity
public class Utente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String email;
	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval=true)
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
