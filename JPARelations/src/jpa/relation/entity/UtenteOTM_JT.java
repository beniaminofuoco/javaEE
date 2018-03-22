package jpa.relation.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: UtenteOTM_JT
 *
 */
@Entity

public class UtenteOTM_JT implements Serializable {

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
	@OneToMany
	@JoinTable(name="utenteotm_jt_indirizzootm_jt",
				joinColumns= {@JoinColumn(name="utenteotm_jt_id", referencedColumnName="id")},
				inverseJoinColumns= {@JoinColumn(name="indirizzi_id", referencedColumnName="id")})
	private List<IndirizzoOTM_JT> indirizzi;

	public UtenteOTM_JT() {
		this.indirizzi = new ArrayList<>();
	}

	public UtenteOTM_JT(String username) {
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

	public List<IndirizzoOTM_JT> getIndirizzi() {
		return indirizzi;
	}

	public void setIndirizzi(List<IndirizzoOTM_JT> indirizzi) {
		this.indirizzi = indirizzi;
	}
   
}
