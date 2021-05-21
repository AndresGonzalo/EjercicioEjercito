package src.main.factory;

import java.util.HashMap;
import java.util.Map;
import src.main.entities.Arquero;
import src.main.entities.Caballero;
import src.main.entities.Piquero;
import src.main.entities.Unidad;

public class UnitFactory {

	static Map<String, Unidad> unitTypes = new HashMap<String, Unidad>();
	
	public static void register(String nombre, String unitClass) throws Exception{
				
	      if(unitClass.equalsIgnoreCase("Piquero")){
	    	 unitTypes.put(nombre, new Piquero());
	    	  
	      } else if(unitClass.equalsIgnoreCase("Arquero")){
	    	  unitTypes.put(nombre, new Arquero());
	         
	      } else if(unitClass.equalsIgnoreCase("Caballero")){
	    	  unitTypes.put(nombre, new Caballero());
	         
	      } else {
	    	  throw new Exception("clase invalida!");
	      }
	}
	
	public static Unidad instatiate(String nombre) throws Exception{
		Unidad unit = unitTypes.get(nombre);
		if(null == unit){
			throw new Exception("unidad no encontrada!");
		} else {
			if(nombre == "piquero"){
				return new Piquero();
			} else if(nombre == "arquero"){
				return new Arquero();
			} else if(nombre == "caballero"){
				return new Caballero();
			} else {
				return null;
			}
			
		}
	}
	
	

}
