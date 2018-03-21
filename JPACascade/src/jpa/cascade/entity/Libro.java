package jpa.cascade.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Libro
 *
 */
@Entity
public class Libro implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String titolo;
	private String autore;
	private static final long serialVersionUID = 1L;

	public Libro() {
		super();
	}   
	
	public Libro(String titolo, String autore) {
		this();
		this.titolo=titolo;
		this.autore=autore;
	}   
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}   
	public String getAutore() {
		return this.autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}
   
}
