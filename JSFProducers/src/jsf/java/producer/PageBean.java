package jsf.java.producer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("page")
@RequestScoped
public class PageBean {

	/**
	 * A questo punto il Produces è generalizzato e quindi mi basta cambiare questo
	 * parametro per specificare qualsiasi fattore.
	 */
	@Inject
	@Fattorizzato(fattore = 5)
	private Moltiplicatore moltiplicatore;

	public Moltiplicatore getMoltiplicatore() {
		return moltiplicatore;
	}

	public void setMoltiplicatore(Moltiplicatore moltiplicatore) {
		this.moltiplicatore = moltiplicatore;
	}
}
