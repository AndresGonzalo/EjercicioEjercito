package src.main.entities;

import java.util.HashMap;
import java.util.Map;

public class Transformador {
	
	Integer capital = 0;
	
	Map<String, String> transformarOpciones  = new HashMap<String, String>() {{
	    put("piquero", "arquero");
	    put("arquero", "caballero");
	}};
	
	Map<String, Integer> transformarCosto  = new HashMap<String, Integer>() {{
	    put("piquero", 30);
	    put("arquero", 40);
	}};
	
	public void work(Ejercito ejercito, String unidadTipo, Integer unidadNumero) throws Exception{
		Integer costo = transformarCosto.get(ejercito.seleccionarUnidad(unidadTipo, unidadNumero).getTipo());
		if(null == costo){
			System.out.println("No se puede transformar un " + unidadTipo);
		} else {
			
			String destino = transformarOpciones.get(unidadTipo);
			ejercito.disminuyeCapital(costo);
			ejercito.eliminarUnidad(unidadTipo, 1);
			ejercito.sumarUnidad(destino, 1);
			this.capital += costo;
			
		}
	}

}
