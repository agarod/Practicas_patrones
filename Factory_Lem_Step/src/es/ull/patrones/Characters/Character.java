package es.ull.patrones.Characters;

import es.ull.patrones.Map.*;



public abstract class Character {
	private String nombre;
	
	public Character(String name){
		nombre = name;
	}
	
	public abstract void action();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void move(Direccion direccion, Habitacion habitacion){
		System.out.println(this.nombre+" esta entrando en "+habitacion.getNumeroHabitacion());
		LugarDelMapa objet;
		objet = habitacion.obtenerLado(direccion);
		objet.Entrar(this);
	}
}
