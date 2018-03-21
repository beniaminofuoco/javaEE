package jpa.cascade.esempi;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import jpa.cascade.entity.JPAExecutor;
import jpa.cascade.entity.Libro;

/**
 * @author Fuoco Beniamino
 * 
 *         Il PERSISTENT CONTEXT è l'insieme di tutte le @Entity il cui ciclo di
 *         vita è gestito dalla JPA.
 * 
 *         Le istanze che appartengono ad un PC si dicono MANAGED.
 * 
 *         L'oggetto EntityManager permette di interagire con il PERSISTENT
 *         CONTEXT.
 * 
 *         - entityManager.contain(Entity) -> ritorna true se l'entity è
 *         presente nel PC, false altrimenti
 *
 *         - entityManager.detach(Entity) -> su una entity MANAGED la fa
 *         diventare DETACHED.
 * 
 * 
 */

public class Test3 extends JPAExecutor {

	@Override
	public void execute() {
		Libro libro = new Libro("GoT", "George RR Martin");

		EntityManager em = createEntityManager();

		// Ritorna FALSE, l'oggetto non conosciuto dal PC
		System.out.println("Punto 1: " + em.contains(libro));

		beginTransaction(em);
		// L'oggetto viene salvato a DB e inserito nel PC
		em.persist(libro); 
		commitTransaction(em);

		// Ritorna TRUE, l'oggetto è inserito nel PC dal metodo Persist
		System.out.println("Punto 2: " + em.contains(libro));

		beginTransaction(em);
		// Il titolo viene modificato e salvato a DB
		libro.setTitolo("Game Of Thrones");
		commitTransaction(em);

		// Ritorna TRUE, l'oggetto è ancora nel PC
		System.out.println("Punto 3: " + em.contains(libro));

		// L'oggetto viene tolto dal PC
		em.detach(libro);

		beginTransaction(em);
		// La modifica viene fatta sull'oggetto "libro" ma NON viene
		// salavata a DB perchè l'oggetto non è più nel PC
		libro.setTitolo("Il gioco dei Troni");
		commitTransaction(em);

		// Ritorna FALSE, l'oggetto NON è più nel PC
		System.out.println("Punto 4: " + em.contains(libro));

		beginTransaction(em);
		// La modifica viene salvata a DB
		em.merge(libro);
		commitTransaction(em);

		// Ritorna sempre FALSE, perchè il metodo MERGE effettua le modifiche 
		// a DB e ritorna un NUOVO oggetto libro che è stato inserito nel PC
		System.out.println("Punto 5: " + em.contains(libro));

		libro = em.merge(libro);
		// Questo nuovo oggetto libro è nel PC -> ritorna TRUE
		System.out.println("Punto 6: " + em.contains(libro));

		em.detach(libro);
		// Ritorna FALSE perchè viene tolto dal PC
		System.out.println("Punto 7: " + em.contains(libro));

		// Se recuperiamo un oggetto tramite una QUERY l'oggetto
		// viene comunque inserito nel PC quindi il Punto 8 ritorna TRUE.
		libro = getLibroFromQuery(em);
		System.out.println("Punto 8: " + em.contains(libro));

		// Chiudiamo l'oggetto Entity Manager
		em.close();
		// Se cerco nel EM dopo averlo chiuso il metodo lancia Eccezione.
		System.out.println("Punto 9: " + em.contains(libro));
	}

	private Libro getLibroFromQuery(EntityManager em) {
		CriteriaQuery<Libro> cq = em.getCriteriaBuilder().createQuery(Libro.class);
		;
		cq.from(Libro.class);
		Query query = em.createQuery(cq);

		return (Libro) query.getResultList().get(0);
	}

	private void beginTransaction(EntityManager em) {
		em.getTransaction().begin();
	}

	private void commitTransaction(EntityManager em) {
		em.getTransaction().commit();
	}

	public static void main(String[] args) {
		Test3 test = new Test3();
		test.execute();
	}
}
