package es.ull.patrones.Map;

import java.util.ArrayList;
import es.ull.patrones.Characters.Character;
import es.ull.patrones.Map.ILugarDelMapa;


public abstract class Habitacion implements ILugarDelMapa {
	
	public static final int NUMLADOS = 4;
	private int numeroHabitacion;
	private ArrayList<Character> characters = new ArrayList<Character>();
	
	private final ILugarDelMapa lados[] = new ILugarDelMapa[NUMLADOS];
	
	public  Habitacion(){
	}
	
	public final ILugarDelMapa obtenerLado(Direccion direccion){
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
	
	public final void establecerLado(Direccion direccion, ILugarDelMapa lugarDelMapa){
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

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) { //Para una posible modificación del laberinto
		this.numeroHabitacion = numeroHabitacion;
	}

	//Número de personajes que se encuentran en la habitación
	public int getNumCharacter() {
		return characters.size();
	}
	
	public Character getCharacter(int index){
		return characters.get(index);
	}
	
	public void AddCharacter(Character character) {
		characters.add(character);
	}
	
	public void RemoveCharacter(Character character){
		characters.remove(character);
	}
	
	@Override
	public void Entrar(Direccion direccion) { //devolver habitacion o numero de habitacion
		// TODO Auto-generated method stub
		System.out.println();
		
	}
	
	@Override
	public void Entrar(Character character) {
		AddCharacter(character);
		character.setLocation(this);
		System.out.println(character.getNombre() + " dentro de habitación: " + this.getNumeroHabitacion());
		propertyRoom();
		// TODO Auto-generated method stub
	}

	public void Salir(Character character) {
		RemoveCharacter(character);
		System.out.println(character.getNombre() + " dejando habitación " + this.getNumeroHabitacion());
		// TODO Auto-generated method stub
	}
	
	@Override
	public void Entrar() {
		// TODO Auto-generated method stub
		
	}
	
	public abstract void propertyRoom();
}