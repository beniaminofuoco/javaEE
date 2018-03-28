package jsf.java.lookup;

import java.io.Serializable;

public abstract class Trasformatore implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public abstract String getValoreTrasformato();
}
