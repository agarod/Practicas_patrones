package es.ull.patrones.Map;
import java.util.ArrayList;


import es.ull.patrones.Characters.Character;
import es.ull.patrones.Map.Location;

public class Laberinto {
	//...
	private int id_laberinto;
	private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	public Laberinto (int id_lab){
		setId_laberinto(id_lab);
		
	}		
	
	public final void situarCharacter(int num_habitacion, Character character){
		//Insertamos el personaje en un lugar concreto de nuestro mapa
		try {
			Habitacion hab = numeroDeHabitacion(num_habitacion);
			anadirCharacterintoHabitacion(hab, character);
		
			//Actualizamos la localización del personaje
			updateLocation(num_habitacion, character);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("La habitación no existe");
		}
	}
	
	public void updateLocation (int habitacion, Character character){
		Location location = new Location();
		location.setHabitacion(habitacion);
		location.setMap(getId_laberinto());
		character.setLocation(location);
	}
	
	public final void anadirHabitacion(Habitacion habitacion){
		setHabitaciones(habitacion);
	}
	
	public final Habitacion numeroDeHabitacion(int numero){
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
	
	public void anadirCharacterintoHabitacion(Habitacion habitacion, Character character){
		habitacion.Entrar(character);
	}
	
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Habitacion habitacion) { //Para una posible modificación del laberinto
		this.habitaciones.add(habitacion);
	}
	
	public int setSizeHabitaciones(){
		return habitaciones.size();
	}

	public int getId_laberinto() {
		return id_laberinto;
	}

	public void setId_laberinto(int id_laberinto) {
		this.id_laberinto = id_laberinto;
	}
}