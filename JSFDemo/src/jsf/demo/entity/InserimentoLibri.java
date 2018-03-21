package jsf.demo.entity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("inserimento")
@RequestScoped
public class InserimentoLibri {

	@Inject
	DatiUtente datiUtente;

	private String titolo;
	private int pagine;

	public void aggiungiLibro() {
		Libro libro = new Libro();
		libro.setTitolo(this.titolo);
		libro.setPagine(this.pagine);
		datiUtente.getLibri().add(libro);
	}

	public String goToTestPage() {
		// Nel seguente modo commentato non cambia la url, cioè non cambia pagina
		// return "testPage.xhmtl";
		return "testPage.xhmtl?faces-redirect=true"; // così cambia pagina
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}
}
