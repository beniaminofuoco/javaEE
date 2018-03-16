package jee.demo.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * 
 * @author Beniamino Fuoco
 *
 * E' una classe instanziata a livello di Application
 * quindi se chiudiamo e riapriamo il browser il valore di count
 * NON si resetta ma rimane inalterato.
 * Il valore viene inizializzato quando si avvia l'applicazione.
 *
 */
@ApplicationScoped
public class ApplicationData {

	private int count;
	
	/**
	 * Anche se l'oggetto viene instanziato all'interno di una classe
	 * con AppplicationScoped, l'oggetto sessionData verrà NUOVAMENTE
	 * instanziato ogni volte che si apre una nuova finestra.
	 * Questo comportamente è gestito da una classe interna chiamata WeldClientProxy.
	 * 
	 * Facendo questo però, se creiamo un costruttore all'interno si SessionData
	 * il costruttore ogni volta verrà richiamato due volte e questo non è bello.
	 */
	@Inject
	private SessionData sessionData;
	
	public synchronized int incrementCount() {
		return this.count++;
	}
	
	public String getInfo() {
		int session = this.sessionData.incrementCount();
		int application = incrementCount();

		return "Application counter = " + application + " Session Counter= " + session;
	}
}
