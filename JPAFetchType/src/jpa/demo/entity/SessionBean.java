package jpa.demo.entity;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -2319833998732750819L;

	@Inject
	private PersistentBean persistentBean;

	private Utente utente;

	private boolean showLibri;

	public void caricaUtente() {
		utente = persistentBean.getUtente();
	}

	public boolean isShowLibri() {
		return this.showLibri;
	}

	public void setShowLibri(boolean showLibri) {
		this.showLibri = showLibri;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
}
