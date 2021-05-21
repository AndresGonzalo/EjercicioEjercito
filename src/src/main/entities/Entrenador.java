package src.main.entities;

import java.util.HashMap;
import java.util.Map;

public class Entrenador {
	
	Map<String, Integer> entrenarCosto  = new HashMap<String, Integer>() {{
	    put("piquero", 10);
	    put("arquero", 20);
	    put("caballero", 30);
	}};
	
	Map<String, Integer> entrenarBeneficio  = new HashMap<String, Integer>() {{
	    put("piquero", 3);
	    put("arquero", 7);
	    put("caballero", 10);
	}};
	
	public void work(Ejercito ejercito, String unidadTipo, Integer unidadNumero) throws Exception{
		
		Integer costo = entrenarCosto.get(ejercito.seleccionarUnidad(unidadTipo, unidadNumero).getTipo());
		Integer beneficio = entrenarBeneficio.get(ejercito.seleccionarUnidad(unidadTipo, unidadNumero).getTipo());
		
		ejercito.disminuyeCapital(costo);
		ejercito.seleccionarUnidad(unidadTipo, unidadNumero).sumaFuerza(beneficio);
		
	}

}
