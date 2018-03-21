package jsf.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("test")
@RequestScoped
public class TestJSF {

	private int numero;
	private List<Integer> lista;
	private Map<String, String> map;

	@PostConstruct
	public void init() {
		this.numero = 10;
		this.lista = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			lista.add(2 * i);
		}
		
		this.map= new HashMap<>();
		this.map.put("chiave", "Valore");
	}

	public int getNumero() {
		return numero * 2;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Integer> getLista() {
		return lista;
	}

	public Map<String, String> getMap() {
		return map;
	}
}
