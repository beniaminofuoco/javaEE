package jee.demo.cdi;

import javax.enterprise.context.Dependent;

/**
 * 
 * @author Fuoco Beniamino
 *
 * Questo scope � diverso da Application, Session o Request.
 * Questa classe andr� ad ereditare lo scope della classe in cui 
 * andremo a fare Inject dell'oggetto DependentData.
 *
 */
@Dependent
public class DependentData {

}
