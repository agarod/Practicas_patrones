package Principal;


import java.util.ArrayList;

import es.ull.patrones.Characters.BadLemming;
import es.ull.patrones.Characters.Character;
import es.ull.patrones.Characters.Lemming;
import es.ull.patrones.Comportamiento.CatchBehaviour;
import es.ull.patrones.Comportamiento.DownArmsBehaviour;
import es.ull.patrones.Laberinto.JuegoDelLaberinto;
import es.ull.patrones.Laberinto.JuegoDelLaberintoConBombas;
import es.ull.patrones.Laberinto.Laberinto;
import es.ull.patrones.Map.Direccion;
import es.ull.patrones.Map.Habitacion;
import es.ull.patrones.Map.Pared;
import es.ull.patrones.Map.Puerta;

public class Principal {
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Habitacion> yyy = new ArrayList<Habitacion>();
		System.out.println("Creamos un laberinto del juego");
		JuegoDelLaberinto laberinto;
		laberinto = new JuegoDelLaberinto();
		System.out.println("Creamos los personajes con su comportamiento");
		Character Lemi = new Lemming("Lemi",new DownArmsBehaviour());
		Character TioMalo = new BadLemming("Lemi Chungo",new CatchBehaviour());
		System.out.println("Comportamiento del prota");
		Lemi.action();
		System.out.println("Comportamiento del malo");
		TioMalo.action();
		Laberinto laberintoNormal = laberinto.crearLaberinto();
		System.out.println(laberintoNormal.getHabitaciones().size());
		
		laberintoNormal.getHabitaciones().get(0).Entrar(Lemi); //Quitar el segundo campo del metodo entrar
		laberintoNormal.getHabitaciones().get(1).Entrar(TioMalo);
		Lemi.move(Direccion.ESTE, laberintoNormal.getHabitaciones().get(0));
		Lemi.move(Direccion.NORTE, laberintoNormal.getHabitaciones().get(0));
		Lemi.move(Direccion.ESTE, laberintoNormal.getHabitaciones().get(0));
		
		
		JuegoDelLaberinto laberinto2;
		laberinto2 = new JuegoDelLaberintoConBombas();
		Character Lemi2 = new Lemming("Lemi2",new DownArmsBehaviour());
		Character Gilgamesh = new BadLemming("Hacedor de desastres",new CatchBehaviour());
		System.out.println("Comportamiento del prota");
		Lemi.action();
		System.out.println("Comportamiento del malo");
		TioMalo.action();
		Laberinto laberintoBomba = laberinto2.crearLaberinto();
		System.out.println(laberintoBomba.getHabitaciones().size());
		
		laberintoBomba.getHabitaciones().get(0).Entrar(Lemi2); 
		laberintoBomba.getHabitaciones().get(0).Entrar(Gilgamesh);
		System.out.println("");
		System.out.println("");
		Lemi2.move(Direccion.ESTE, laberintoBomba.getHabitaciones().get(0));
		Lemi2.move(Direccion.OESTE, laberintoBomba.getHabitaciones().get(0));
		Lemi2.move(Direccion.ESTE, laberintoBomba.getHabitaciones().get(1));
		
	}

}
