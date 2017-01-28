package es.ull.patrones.Map;

import java.util.ArrayList;

import es.ull.patrones.Characters.Character;



public abstract class Habitacion implements LugarDelMapa {

	public static final int NUMLADOS = 4;
	private int numeroHabitacion;
	private final LugarDelMapa lados[] = new LugarDelMapa[NUMLADOS];
	private ArrayList<Character> characters = new ArrayList<Character>();
	
	public Habitacion(){}
	public Habitacion(int numHabitacion) {}
	
	public final LugarDelMapa obtenerLado(Direccion direccion){
		switch (direccion) {
		case NORTE:
			return lados[0];
		case SUR:
			return lados[2];
		case ESTE:
			return lados[1];
		case OESTE:
			return lados[3];
		default:
			return null;
		}
	}
	public final void establecerLado(Direccion direccion, LugarDelMapa lugarDelMapa) {
		switch (direccion) {
		case NORTE:
			lados[0] = lugarDelMapa;
			break;
		case SUR:
			lados[2] = lugarDelMapa;
			break;
		case ESTE:
			lados[1] = lugarDelMapa;
			break;
		case OESTE:
			lados[3] = lugarDelMapa;
			break;
		}
	}
//	@Override
//	public void Entrar(Character personaje) {
//		System.out.println(personaje.getNombre()+ "Ha entrado en la habitacion");	
//	}
	
	public int getNumeroHabitacion() {
		//return 2;
		return numeroHabitacion;
		
	}

	public void setNumeroHabitacion(int numeroHabitacion) { //Para una posible modificación del laberinto
		this.numeroHabitacion = numeroHabitacion;
	}
	
	@Override
	public void Entrar(Character character) {
		AddCharacter(character);
		character.setLocation(this);
		System.out.println(character.getNombre() + " dentro de habitación: " + this.getNumeroHabitacion());
		propertyRoom();
		// TODO Auto-generated method stub
	}
	public void AddCharacter(Character character) {
		characters.add(character);
	}
	public int getNumCharacter() {
		return characters.size();
	}
	public abstract void propertyRoom();
}



