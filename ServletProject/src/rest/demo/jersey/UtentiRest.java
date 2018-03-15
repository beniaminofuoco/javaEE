package rest.demo.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("utenti")
public class UtentiRest {
	
	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_XML)
	public String getUtentiXML(@PathParam("userId") int id) {
		return "Devo cercare l'utente "+id;
	}

}
