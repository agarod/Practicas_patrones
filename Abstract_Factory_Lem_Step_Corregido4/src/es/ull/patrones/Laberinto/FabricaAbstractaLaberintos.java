package es.ull.patrones.Laberinto;

import es.ull.patrones.Map.Habitacion;
import es.ull.patrones.Map.Pared;
import es.ull.patrones.Map.PuertaBomba;
import es.ull.patrones.Map.PuertaNORMAL;


public interface FabricaAbstractaLaberintos  {
	
	public PuertaNORMAL fabricarPuerta(Habitacion h1, Habitacion h2);
	public PuertaBomba fabricarPuertaBomba(Habitacion h1, Habitacion h2);
	
	public Habitacion fabricarHabitacion(int n);
	
	public Pared fabricarPared();
	
	public void accion();
	
	
	
	
}
