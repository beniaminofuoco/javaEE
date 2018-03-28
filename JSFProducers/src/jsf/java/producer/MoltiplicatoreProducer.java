package jsf.java.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * 
 * @author Fuoco Beniamino
 * 
 *         I Produces sono dei metodi che permettono di generare istante di Bean
 *         che possono essere gestite dal CDI.
 * 
 *         I Produces si utilizzano quando si vogliono creare dei Bean per:
 *         -Classi che non sono Bean (per esempio senza un Costruttore senza
 *         parametri) -Implementazioni multiple della stessa interfaccia
 *         (selezionate a Runtime) -Più istanze dello stesso Bean con Scope
 *         diversi
 * 
 */
@ApplicationScoped
public class MoltiplicatoreProducer {

	/**
	 * L'annotation Produces ha uno scope Dependent, cioè dipende dallo Scope dove
	 * viene iniettato il Bean. Se vogliamo dargli uno Scope suo dobbiamo inserire
	 * un'annotation sul metodo (in questo esempio specificiamo Session).
	 * 
	 * PS: un bean con Scope Session deve essere Serializable
	 * 
	 * @return {@link Moltiplicatore}
	 * 
	 *         InjectionPoint funziona solo quando è utilizzato con Scope Dependent
	 *         quindi togliamo il SessionScope
	 */
	@Produces
	@Fattorizzato
	public Moltiplicatore getMoltiplicatore(InjectionPoint injectionPoint) {
		int fattore = injectionPoint.getAnnotated().getAnnotation(Fattorizzato.class).fattore();
		return new Moltiplicatore(fattore);
	}

	/**
	 * Se aggiungiamo un secondo metodo l'applicativo va in confusione, perchè non
	 * sa se instanziare uno o l'altro Produces. Per risolvere questo problema si
	 * utilizza un Qualified.
	 * 
	 * @return {@link Moltiplicatore}
	 * 
	 * @Produces
	 * @Fattorizzato(fattore = 3)
	 * @SessionScoped public Moltiplicatore getTriplicatore() { return new
	 *                Moltiplicatore(3); }
	 */
}
