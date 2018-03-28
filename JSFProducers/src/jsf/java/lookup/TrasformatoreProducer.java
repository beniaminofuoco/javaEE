package jsf.java.lookup;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class TrasformatoreProducer {

	@Produces
	@SessionScoped
	@Tipizzato(Tipo.MAIUSCOLATORE)
	public Trasformatore getMaiuscolatore() {
		return new Maiuscolatore();
	}

	@Produces
	@SessionScoped
	@Tipizzato(Tipo.INVERTITORE)
	public Trasformatore getInvertitore() {
		return new Invertitore();
	}
}
