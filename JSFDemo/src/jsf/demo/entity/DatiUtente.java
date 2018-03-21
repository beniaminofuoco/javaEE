package jsf.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("utente")
@SessionScoped
public class DatiUtente implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 8681005814085891101L;

	private List<Libro> libri;
	
	@PostConstruct
	public void init() {
		this.libri =new ArrayList<>();
	}

	public List<Libro> getLibri() {
		return libri;
	}
}
