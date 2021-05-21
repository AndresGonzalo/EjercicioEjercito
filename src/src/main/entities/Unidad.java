package src.main.entities;

import java.util.Comparator;

public class Unidad implements Comparable<Unidad>{
	
	private Integer fuerza;
	private String tipo;
	
	public Unidad(String tipo, Integer fuerza){
		this.tipo = tipo;
		this.fuerza = fuerza;
	}
	
	public Integer getFuerza() {
		return fuerza;
	}

	public Integer sumaFuerza(Integer fuerza){
		return this.fuerza += fuerza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
    public String toString() {
        return this.tipo + " fuerza: " + this.fuerza + "-";
    }

	@Override
	public int compareTo(Unidad o) {
		if(fuerza==o.getFuerza())  
			return 0;  
			else if(fuerza>o.getFuerza())  
			return 1;  
			else  
			return -1;  
	}

}