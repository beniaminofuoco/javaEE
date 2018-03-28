package jsf.java.lookup;

public class Maiuscolatore extends Trasformatore {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getValoreTrasformato() {
		if (getValue() == null) {
			return null;
		}
		return getValue().toUpperCase();
	}
}
