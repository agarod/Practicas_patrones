package es.ull.patrones.Laberinto;


//import es.ull.patrones.Map.Pared;
//import es.ull.patrones.Map.Habitacion;
//import es.ull.patrones.Map.Direccion;
//import es.ull.patrones.Map.Puerta;
import es.ull.patrones.Map.*;


public class JuegoDelLaberinto {

//	public final Laberinto crearLaberinto() {
	public Laberinto crearLaberinto(){
		//...
		
		Laberinto unLaberinto = new Laberinto();
		Habitacion h1 = new Habitacion(1);
		Habitacion h2 = new Habitacion(2);
		unLaberinto.anadirHabitacion(h1);
		unLaberinto.anadirHabitacion(h2);
		Puerta laPuerta = fabricarPuerta(h1, h2);
		h1.establecerLado(Direccion.NORTE, fabricarPared());
		h1.establecerLado(Direccion.ESTE, laPuerta);
		h1.establecerLado(Direccion.SUR, fabricarPared());
		h1.establecerLado(Direccion.OESTE, fabricarPared());
		h2.establecerLado(Direccion.NORTE, fabricarPared());
		h2.establecerLado(Direccion.ESTE, fabricarPared());
		h2.establecerLado(Direccion.SUR, fabricarPared());
		h2.establecerLado(Direccion.OESTE, laPuerta);
		return unLaberinto;
	}

	public Pared fabricarPared() {
		return new Pared();
	}
	
	public Puerta fabricarPuerta(Habitacion h1, Habitacion h2) {
		return new Puerta(h1, h2);
	}
}
