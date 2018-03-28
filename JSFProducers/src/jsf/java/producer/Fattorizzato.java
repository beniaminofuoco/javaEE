package jsf.java.producer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

/**
 * 
 * @author Fuoco Beniamino
 * 
 *         Quando utilizziamo una Qualifier è come se creassimo una nostra
 *         Annotation. La Ratention indica la visibilità dell'Annotation: -
 *         Source-> indica che l'annotation verrà rimossa in fase di
 *         compilazione(Es. SuppressedWarning). - Runtime-> l'annotation è
 *         visibile anche in fase di esecuzione del codice. - Class-> è una via
 *         di mezzo tra le due, più precisamente l'annotation viene tolta quando
 *         la classe viene caricata in memoria.
 * 
 *         Target indica dove possiamo indicare la notazione che stiamo creando,
 *         nel nostro esempio possiamo specificarlo a livello di classe,
 *         Metodo,Campo e Parametro.
 *
 **/
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
public @interface Fattorizzato {

	/**
	 * Per distinguere i due metodi creati(raddoppiatore e triplicatore) specifico
	 * un valore(fattore)con valore di default.
	 * 
	 * @return int
	 * 
	 *         l'annotation @Nonbinding ci permette di generalizzare il valore di
	 *         fattore
	 */
	@Nonbinding
	int fattore() default 1;

}
