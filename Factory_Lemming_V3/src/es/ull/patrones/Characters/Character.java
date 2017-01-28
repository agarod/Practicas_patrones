package es.ull.patrones.Characters;

//import Clases.Direccion;
//import Clases.Habitacion;
//import Interface.ILugarDelMapa;
import es.ull.patrones.Comportamiento.IBehaviour;
import es.ull.patrones.Map.Location;
import es.ull.patrones.Contexto.Contexto;
import es.ull.patrones.Map.Direccion;
import es.ull.patrones.Map.Habitacion;
import es.ull.patrones.Map.ILugarDelMapa;

public abstract class Character {
	private String nombre;
	private IBehaviour conduct;
	private int figth;
	private Location location = new Location(); //En principio un personaje solo puede existir en un mapa
	
	public Character(String name){
		nombre = name;
		//setFigth(0);
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
	public void abrirCelda(Direccion direccion, Habitacion habitacion) {
		// TODO Auto-generated method stub
		
	}
}