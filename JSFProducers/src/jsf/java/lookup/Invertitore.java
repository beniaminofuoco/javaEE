package jsf.java.lookup;

public class Invertitore extends Trasformatore{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getValoreTrasformato() {
		if(getValue()==null) {
			return null;
		}
		return new StringBuilder(getValue()).reverse().toString();
	}
}
