package rest.demo.jersey;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jse.demo.jaxb.Utente;

@Path("utenti")
public class UtentiRest {
	
	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utente getUtentiXML(@PathParam("userId") int id) {
		Utente user =  new Utente();
		user.setEmail("pippo@iol.it");
		user.setNome("Pippo");
		return user;
	}
	
	@POST
	@Path("testPost")
	@Produces(MediaType.APPLICATION_JSON)
	public String postUtenti(@FormParam("valore") String valore) {
		return "Il valore del paramentro in ingresso è: "+valore;
	}

}
