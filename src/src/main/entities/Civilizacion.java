package src.main.entities;

import java.util.HashMap;
import java.util.Map;

public class Civilizacion {
	
	private String nombre;
	Map<String, Integer> configEjercito = new HashMap<String, Integer>();
	
	public Civilizacion(String nombre, Integer piqueros, Integer arqueros, Integer caballeros){
		this.nombre = nombre;
		this.configEjercito.put("piquero", piqueros);
		this.configEjercito.put("arquero", arqueros);
		this.configEjercito.put("caballero", caballeros);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<String, Integer> getConfigEjercito() {
		return configEjercito;
	}
	
}
