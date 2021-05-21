package src.main.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import src.main.utilities.Historial;

public class Batalla {
	
	//ESTO SE DEBERIA SETEAR EXTERNAMENTE
	private static final int cantUnidadesPerdidas = 2;

	public void work(Ejercito ejercito1, Ejercito ejercito2){
		
		
		Integer puntaje1 = ejercito1.obtenerPuntos();
		Integer puntaje2 = ejercito2.obtenerPuntos();
		if(puntaje1.equals(puntaje2)){
			procesarEmpate(ejercito1, ejercito2);
		} else if(puntaje1 > puntaje2) {
			ganar(ejercito1);
			perder(ejercito2);
			procesarGanador(ejercito1,ejercito2);
			procesarPerdedor(ejercito1, ejercito2);
		} else {
			procesarGanador(ejercito2, ejercito1);
			procesarPerdedor(ejercito2, ejercito1);
			ganar(ejercito2);
			perder(ejercito1);
		}
		
		
	}
	
	//EL EJERCITO GANADOR GANA 100 UNIDADES DE ORO
	private void ganar(Ejercito ejercito){
		ejercito.aumentaCapital(100);
	}
	
	
	//EL EJERCITO PERDEDOR PIERDE 2 DE SUS UNIDADES CON MAYOR PUNTAJE
	private void perder(Ejercito ejercito){
		for(int i = 0; i < cantUnidadesPerdidas; i++){
			ejercito.eliminarUnidadEspecifica(ejercito.obtenerPosicionUnidadMayorPuntaje());
		}
	}
	
	//SI HAY EMPATE CADA EJERCITO PIERDE SU UNIDAD DE MENOR PUNTAJE
	private void empatar(Ejercito eje1, Ejercito eje2){
		eje1.eliminarUnidadEspecifica(eje1.obtenerPosicionUnidadMenorPuntaje());
		eje2.eliminarUnidadEspecifica(eje2.obtenerPosicionUnidadMenorPuntaje());
	}
	
	public void procesarGanador(Ejercito ganador, Ejercito perdedor){
		String fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Historial resultado = new Historial();
		resultado.setEjercitoEnemigo(perdedor.getNombre());
		resultado.setResultado("V");
		ganador.agregarAlHistorial(fechaHora , resultado);
	}
	
	public void procesarPerdedor(Ejercito ganador, Ejercito perdedor){
		String fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Historial resultado = new Historial();
		resultado.setEjercitoEnemigo(ganador.getNombre());
		resultado.setResultado("D");
		perdedor.agregarAlHistorial(fechaHora, resultado);
	}
	
	public void procesarEmpate(Ejercito eje1, Ejercito eje2){
		empatar(eje1, eje2);
		String fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Historial resultado1 = new Historial();
		resultado1.setEjercitoEnemigo(eje2.getNombre());
		resultado1.setResultado("E");
		eje1.agregarAlHistorial(fechaHora, resultado1);
		Historial resultado2 = new Historial();
		resultado2.setEjercitoEnemigo(eje1.getNombre());
		resultado2.setResultado("E");
		eje2.agregarAlHistorial(fechaHora, resultado2);
	}

}
