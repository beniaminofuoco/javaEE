package jsf.java.producer;

import java.io.Serializable;

public class Moltiplicatore implements Serializable{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	private final int fattore;
	private int value;
	
	public Moltiplicatore() {
		this(1);
	}

	public Moltiplicatore(int fattore) {
		this.fattore = fattore;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getFattore() {
		return fattore;
	}

	public int getValoreMoltiplicato() {
		return this.fattore*this.value;
	}
}
