package es.ull.patrones.Laberinto;

import es.ull.patrones.Map.Habitacion;
import es.ull.patrones.Map.Laberinto;
import es.ull.patrones.Map.Pared;
import es.ull.patrones.Map.Puerta;

//import Clases.Habitacion;
//import Clases.Laberinto;
//import Clases.Pared;
//import Clases.Puerta;
//import TypeHabitacion.HNormal;
//import TypePuertas.PHechizo;
//import TypePuertas.PNormal;

public abstract class JuegoDelLaberinto {

	// Métodos de fabricación
	public Laberinto fabricarLaberinto(int id) {
		return new Laberinto(id);
	}
	
	public Habitacion fabricarHabitacion(int n) {
		return new HNormal(n);
	}
	
	public Pared fabricarPared() {
		return new Pared();
	}
	
	public Puerta fabricarPuerta(Habitacion h1, Habitacion h2) {
		return new PNormal(h1, h2);
	}
	
	public Puerta fabricarPuertaHechizada(Habitacion h1, Habitacion h2) {
		return new PHechizo(h1, h2);
	}
			
	public abstract Laberinto crearLaberinto();
}