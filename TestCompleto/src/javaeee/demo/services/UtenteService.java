package javaeee.demo.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javaee.demo.entity.Utente;

@RequestScoped
@Path("utente")
public class UtenteService {
	
	@PersistenceContext(unitName="TestCompleto")
	private EntityManager em;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@SuppressWarnings("unchecked")
	public List<Utente> getUsers(){
		Query query = em.createNamedQuery("Utente.findAll", Utente.class);
		return query.getResultList();
	}
	
	@POST
	@Transactional
	public void aggiungiUtenti(@FormParam("username") String username, @FormParam("email") String email) {
		Utente utente =  new Utente();
		utente.setEmail(email);
		utente.setUsername(username);
		this.em.persist(utente);
	}
	
}
