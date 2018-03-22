package jpa.relation.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Indirizzo
 *
 */
@Entity

public class Indirizzo implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String via;
	private String citta;
	
	/**
	 * Nel caso 1-to-1, manteniamo la relazione INVERSA
	 * specificando il campo che mappa la relazione,
	 * cioè il campo indirizzo della classe Utente
	 *
	 */
	@OneToOne(mappedBy="indirizzo")
	private Utente utente;

	public Indirizzo() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}   
	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
}
