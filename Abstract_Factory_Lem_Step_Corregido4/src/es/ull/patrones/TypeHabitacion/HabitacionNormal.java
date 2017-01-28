package es.ull.patrones.TypeHabitacion;

import es.ull.patrones.Map.Habitacion;

public class HabitacionNormal extends Habitacion {

	public HabitacionNormal(int numHabitacion) {
		//super(numHabitacion);
		System.out.println("Num Hab Normal");
		System.out.println(numHabitacion);
		setNumeroHabitacion(numHabitacion);
	}

	@Override
	public void propertyRoom() {
		System.out.println("Ha entrado en una Casa");
		System.out.println("Número de gente: "+ getNumCharacter());
	}

}
