package es.ull.patrones.Laberinto;

import es.ull.patrones.Map.Habitacion;
import es.ull.patrones.Map.Puerta;
import es.ull.patrones.Map.PuertaBomba;
import es.ull.patrones.Map.PuertaNORMAL;
import es.ull.patrones.TypeHabitacion.HabitacionNormal;

public class JuegoDelLaberintoConBombas extends JuegoDelLaberinto {
//	public Laberinto crearLaberinto() {
//		
//		Laberinto unLaberinto = new Laberinto();
//		Habitacion h1 = new Habitacion(1);
//		Habitacion h2 = new Habitacion(2);
//		unLaberinto.anadirHabitacion(h1);
//		unLaberinto.anadirHabitacion(h2);
//		Puerta laPuerta = fabricarPuerta(h1, h2);
//		Puerta PuertaB = fabricarPuertaBomba(h1,h2);
//		h1.establecerLado(Direccion.NORTE, fabricarPared());
//		h1.establecerLado(Direccion.ESTE, PuertaB);
//		h1.establecerLado(Direccion.SUR, fabricarPared());
//		h1.establecerLado(Direccion.OESTE, fabricarPared());
//		h2.establecerLado(Direccion.NORTE, fabricarPared());
//		h2.establecerLado(Direccion.ESTE, fabricarPared());
//		h2.establecerLado(Direccion.SUR, fabricarPared());
//		h2.establecerLado(Direccion.OESTE, PuertaB);
//		return unLaberinto;
//	}
	public Habitacion fabricarHabitacion(int n) {
		return new HabitacionNormal(n);
	}
	public Puerta fabricarPuerta(Habitacion h1, Habitacion h2) {
		return new PuertaNORMAL(h1, h2);
	}
	public PuertaBomba fabricarPuertaBomba(Habitacion h1, Habitacion h2){
		return new PuertaBomba(h1,h2);
	}
}
