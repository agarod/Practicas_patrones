package es.ull.patrones.Habitacion;

import es.ull.patrones.Clases.Direccion;
import es.ull.patrones.Interfaces.ILugarDelMapa;

public class Habitacion implements ILugarDelMapa {
	 public static final int NUMLADOS = 4;
	 private int numeroHabitacion;
	 private final ILugarDelMapa lados[] = new ILugarDelMapa[NUMLADOS];
	 public Habitacion(int numHabitacion) {}
	 public final ILugarDelMapa obtenerLado(Direccion direccion){}
	 public final void establecerLado(Direccion direccion, ILugarDelMapa 
	lugarDelMapa) {}
	 @Override
	 public void Entrar() {}
	}

