package src.main.utilities;

import src.main.entities.Batalla;
import src.main.entities.Civilizacion;
import src.main.entities.Ejercito;
import src.main.entities.Entrenador;

public class GameBoard {
	
	Configuracion conf = new Configuracion();
	
	public void inicializar(){
		conf.inicializar();
	}
	
	public void jugar(){
		Civilizacion civ = conf.obtenerCivilizacion("chinos");
		Civilizacion civ2 = conf.obtenerCivilizacion("ingleses");
		Entrenador ent = new Entrenador();
		try {
			Ejercito ejer = new Ejercito("ejercito1", 1000, civ);
			Ejercito ejer2 = new Ejercito("ejercito2", 1000, civ2);
			ent.work(ejer, "caballero", 1);
//			ejer.imprimirDetalles();
			ent.work(ejer2, "caballero", 1);
			ent.work(ejer2, "caballero", 0);
//			ejer2.imprimirDetalles();
			Batalla batalla = new Batalla();
			batalla.work(ejer, ejer2);
			ejer.imprimirDetalles();
			ejer2.imprimirDetalles();
			ejer.imprimirHistorial();
			ejer2.imprimirHistorial();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void agregarCivilizacion(String nombre, Integer cantPiqueros, Integer cantArqueros, Integer cantCaballeros){
		conf.agregarCivilizacion(nombre, cantPiqueros, cantArqueros, cantCaballeros);
	}

}
