package jsf.java.lookup;

import javax.enterprise.util.AnnotationLiteral;

public class TipizzatoQualifier extends AnnotationLiteral<Tipizzato> implements Tipizzato {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	private final Tipo tipo;
	
	public TipizzatoQualifier(Tipo tipo) {
		this.tipo=tipo;
	}

	@Override
	public Tipo value() {
		return this.tipo;
	}

}
