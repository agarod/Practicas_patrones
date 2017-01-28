package es.ull.patrones.Habitacion;

import es.ull.patrones.Interfaces.ILugarDelMapa;

public class Puerta implements ILugarDelMapa {
private Habitacion habitacion1;
private Habitacion habitacion2;
private boolean estaAbierta;
public Puerta(Habitacion habitacion1, Habitacion habitacion2) {}
public final Habitacion otroLadoDe(Habitacion habitacion){
	return habitacion; }
@Override
public void Entrar() {}
}
