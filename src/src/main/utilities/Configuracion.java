package src.main.utilities;

import java.util.HashMap;
import java.util.Map;

import src.main.entities.Civilizacion;
import src.main.factory.UnitFactory;

public class Configuracion {
	
	Map<String, Civilizacion> civilizaciones = new HashMap<String, Civilizacion>();
	
	//ESTA INFORMACION DEBERIA PODER MODIFICARSE EXTERNAMENTE
	Integer capitalInicial = 0;
	
	public void inicializar(){
		//ESTA INFORMACION DEBERIA PODER MODIFICARSE EXTERNAMENTE
		civilizaciones.put("chinos", new Civilizacion("chinos", 2, 25, 2));
		civilizaciones.put("ingleses", new Civilizacion("Ingleses", 10, 10, 10));
		civilizaciones.put("bizantinos", new Civilizacion("Bizantinos", 5, 8, 15));
		capitalInicial = 1000;
		
		try {
			UnitFactory.register("piquero", "Piquero");
			UnitFactory.register("arquero", "Arquero");
			UnitFactory.register("caballero", "Caballero");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void agregarCivilizacion(String nombre, Integer cantPiqueros, Integer cantArqueros, Integer cantCaballeros){
		civilizaciones.put(nombre, new Civilizacion(nombre, cantPiqueros, cantArqueros, cantCaballeros));
	}
	
	public Civilizacion obtenerCivilizacion(String nombre){
		return civilizaciones.get(nombre);
	}

}