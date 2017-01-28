package es.ull.patrones.characters.ull.es;

import javax.xml.stream.Location;

import Clases.Direccion;
import Clases.Habitacion;
import Clases.ILugarDelMapa;
import es.ull.patrones.comportamiento.ull.es.IBehaviour;

public abstract class Character {
	private String nombre;
	private IBehaviour conduct;
	private int figth;
	private Location location = new Location(); //En principio un personaje solo puede existir en un mapa
	
	
	public Character(String name){
		nombre = name;
		setFigth(0);
		Contexto cont = new Contexto();
		conduct = cont.strategy(this);
	}
	public Character(int i){
		figth = i;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public IBehaviour getConduct() {
		return conduct;
	}

	public void setConduct(IBehaviour conduct) {
		this.conduct = conduct;
	}

	public int getFigth() {
		return figth;
	}

	public void setFigth(int figth) {
		this.figth = figth;
	}
	
	public void incrementFigth(int i){
		int battle = getFigth();
		setFigth(i + battle);
	}
	
	public void decrementFigth(int i){
		int battle = getFigth();
		setFigth(battle - i);
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	//Paso un objeto habitación en lugar del identificador de la habitación
	//para dar la posibilidad de que un personaje s mueva entre laberintos 
	//a traves de una habitación que sea un tunel entre ambos mapas
	public void setLocation(Habitacion habitacion) {
		int num_hab = habitacion.getNumeroHabitacion();
		this.location.setHabitacion(num_hab);
	}

	//Preguntarle al profesor si debería estar en otra clase, por los tipos de movimientos y demás
	public void move(Direccion direccion, Habitacion habitacion){
		ILugarDelMapa objet;
		objet = habitacion.obtenerLado(direccion);
		objet.Entrar(this);
	}


	
	public abstract void abrirCelda(Direccion direccion, Habitacion habitacion);
	
}