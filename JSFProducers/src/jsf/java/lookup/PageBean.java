package jsf.java.lookup;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

@Named("lookup")
@SessionScoped
public class PageBean implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	private Tipo tipo;
	
	@Inject
	@Any
	private Instance<Trasformatore> trasformatori;

	@PostConstruct
	public void init() {
		this.tipo = Tipo.MAIUSCOLATORE;
	}
	
	public Trasformatore getTrasformatore() {
		return this.trasformatori.select(new TipizzatoQualifier(this.tipo)).get();
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
