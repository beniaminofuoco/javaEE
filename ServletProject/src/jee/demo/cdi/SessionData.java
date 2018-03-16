package jee.demo.cdi;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

/**
 * 
 * @author Beniamino Fuoco
 * 
 *         Tale classe viene instanziata a livello di Sessione, quindi se viene
 *         chiuso e riaperto il browser la classe viene NUOVAMENTE instanziata.
 *         Implemento l'interfaccia Serializable è utile qualora si volesse
 *         memorizzare una Sessione per inviarla sulla rete oppure utilizzarla
 *         fra più Server in cluster.
 *
 */
@SessionScoped
public class SessionData implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -5910653537999063052L;

	private int count;

	/**
	 * Metedo analogo al Costruttore che viene richiamato UNA sola volta
	 */
	@PostConstruct
	public void init() {
		System.out.println("Costruttore SessionData");
	}

	public synchronized int incrementCount() {
		return this.count++;
	}

}
