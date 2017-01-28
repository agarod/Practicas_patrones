package es.ull.patrones.Laberinto;

import java.util.ArrayList;

import es.ull.patrones.Map.Habitacion;

public class Laberinto {
	// ....
	private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	
	
	public final void anadirHabitacion(Habitacion habitacion) {
		setHabitaciones(habitacion);
	}
	public final Habitacion numeroDeHabitacion(int numero) {
		//Con la instancia de la habitación devolver su número
		boolean encontrado = false;
		Habitacion hab = null;
		int i = 0;
		while (!encontrado){
			hab = habitaciones.get(i);
			if (hab.getNumeroHabitacion() == numero)
				encontrado = true;
			else if (setSizeHabitaciones() -1 == i ){
				hab = null;
				encontrado = true;
			}	
			else
				i++;
		}
		return hab;
	}
		
	public void setHabitaciones(Habitacion habitacion) { 
		this.habitaciones.add(habitacion);
	}
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	public int setSizeHabitaciones(){
		return habitaciones.size();
	}
}
