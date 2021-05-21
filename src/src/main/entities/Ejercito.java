package src.main.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import src.main.factory.UnitFactory;
import src.main.utilities.Historial;
import src.main.utilities.Posicion;

public class Ejercito {

	private String nombre;
	private Integer capital;
	private String civilizacionNombre;
	//COMO LAS BATALLAS NO TIENEN NOMBRE LAS IDENTIFICO POR FECHA Y HORA
	private Map<String, Historial> historial = new HashMap<String, Historial>();
	Map<String, List<Unidad>> unidades = new HashMap<String, List<Unidad>>();
	
	public Ejercito(String nombre, Integer capital, Civilizacion civilizacion) throws Exception{
		this.nombre = nombre;
		this.capital = capital;
		this.civilizacionNombre = civilizacion.getNombre();
		for(Map.Entry<String, Integer> entry: civilizacion.getConfigEjercito().entrySet()){
			List<Unidad> listadoUnidades = new ArrayList<Unidad>();
			for(int i = 0; i < entry.getValue(); i++){
				listadoUnidades.add(UnitFactory.instatiate(entry.getKey()));
			}
			unidades.put(entry.getKey(), listadoUnidades);
		}
	}
	
	public Integer obtenerPuntos(){
		Integer puntos = 0;
		Set<String> keySet = unidades.keySet();
		for(String key : keySet){
			for(Unidad unidad : unidades.get(key)){
				puntos += unidad.getFuerza();
			}
		}
		return puntos;
	}
	
	public void aumentaCapital(Integer monto){
		this.capital += monto;
	}
	
	public void disminuyeCapital(Integer monto) throws Exception{
		if(this.capital - monto >= 0){
			this.capital -= monto;
		} else{
			throw new Exception("No tiene capital para esta operacion");
		}
	}
	
	public void eliminarUnidad(String unidadTipo, Integer unidadNumero){
		for(int i = 0; i < unidadNumero; i++){
			this.unidades.get(unidadTipo).remove(0);			
		}
	}
	
	public void sumarUnidad(String unidadTipo, Integer unidadNumero) throws Exception{
		for(int i = 0; i < unidadNumero; i++){
			this.unidades.get(unidadTipo).add(UnitFactory.instatiate(unidadTipo));			
		}
	}
	
	public Unidad seleccionarUnidad(String unidadTipo, Integer unidadNumero){
		return this.unidades.get(unidadTipo).get(unidadNumero);
	}
	
	public Posicion obtenerPosicionUnidadMayorPuntaje(){
		Posicion posicion = new Posicion();
		Unidad max = null;
		Integer i=0;
		Integer maxIndex=-1;
		for (Map.Entry<String, List<Unidad>> entry : unidades.entrySet()){
			i=0;
			for (Unidad x : entry.getValue()) {
			    if ((x!=null) && ((max==null) || (x.getFuerza()>max.getFuerza()))) {
			      max = x;
			      maxIndex = i;
			    }
			    i++;
			  }
		}
		posicion.setIndice(maxIndex);
		posicion.setKey(max.getTipo());
		return posicion;
	}
	
	public Posicion obtenerPosicionUnidadMenorPuntaje(){
		Posicion posicion = new Posicion();
		Unidad max = null;
		Integer i=0;
		Integer maxIndex=-1;
		for (Map.Entry<String, List<Unidad>> entry : unidades.entrySet()){
			i=0;
			for (Unidad x : entry.getValue()) {
			    if ((x!=null) && ((max==null) || (x.getFuerza()<max.getFuerza()))) {
			      max = x;
			      maxIndex = i;
			    }
			    i++;
			  }
		}
		posicion.setIndice(maxIndex);
		posicion.setKey(max.getTipo());
		return posicion;
	}
	
	public void eliminarUnidadEspecifica(Posicion posicion){
		this.unidades.get(posicion.getKey()).remove(posicion.getIndice());
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCivilizacionNombre() {
		return civilizacionNombre;
	}

	public void setCivilizacionNombre(String civilizacionNombre) {
		this.civilizacionNombre = civilizacionNombre;
	}
	
	public Map<String, Historial> getHistorial() {
		return historial;
	}

	public void agregarAlHistorial(String fechaHora, Historial resultado){
		this.historial.put(fechaHora, resultado);
	}

	public void imprimirDetalles(){
		System.out.println("Capital actual: " + this.capital);
		for (Map.Entry<String, List<Unidad>> entry : unidades.entrySet()){
			System.out.println(entry.getKey());
			for(Unidad unidad : entry.getValue()){
				System.out.println(unidad.toString());
			}
		}
	}
	
	public void imprimirHistorial(){
		for (Map.Entry<String, Historial> entry : historial.entrySet()){
			System.out.println(entry.getKey() + " - Enemigo: " + entry.getValue().getEjercitoEnemigo() + " Resultado: " + entry.getValue().getResultado());
		}
	}
	
}