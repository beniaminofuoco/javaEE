package jpa.relation.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: IndirizzoOTM_JT
 *
 */
@Entity

public class IndirizzoOTM_JT implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String via;
	private String citta;

	/**
	 * Nel caso 1-to-N lato Utente,lato Indirizzo avremo una N-to-1 e quindi
	 * specificheremo la colonna(sulla tabella Indirizzo) che andrà a legare più
	 * indirizzi allo stesso utente(id_utente).
	 */
	@ManyToOne
	@JoinTable(name = "utenteotm_jt_indirizzootm_jt", joinColumns = {
			@JoinColumn(name = "indirizzi_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "utenteotm_jt_id", referencedColumnName = "id") })
	private UtenteOTM_JT utente;

	public IndirizzoOTM_JT() {
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

	public UtenteOTM_JT getUtente() {
		return utente;
	}

	public void setUtente(UtenteOTM_JT utente) {
		this.utente = utente;
	}
}
