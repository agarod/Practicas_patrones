package Principal;





import Mediator.CanalEmisora;
import es.ull.patrones.Characters.BadLemming;
import es.ull.patrones.Characters.Character;
import es.ull.patrones.Characters.Lemming;
import es.ull.patrones.Comportamiento.CatchBehaviour;
import es.ull.patrones.Comportamiento.DownArmsBehaviour;
import es.ull.patrones.GUI.Ventana;
import es.ull.patrones.Laberinto.FabricaAbstractaLaberintos;
import es.ull.patrones.Laberinto.JuegoDelLaberintoNormal;
import es.ull.patrones.Laberinto.Laberinto;
import es.ull.patrones.Location.Location;
import es.ull.patrones.Map.Direccion;
import es.ull.patrones.Map.Habitacion;
import es.ull.patrones.Map.Puerta;
import es.ull.patrones.TypeHabitacion.HabitacionNormal;

public class Principal {
	public static Laberinto crearLaberinto(FabricaAbstractaLaberintos laberinto){
		Laberinto unLaberinto = new Laberinto(3);
		Habitacion h1 = new HabitacionNormal(1);
		Habitacion h2 = new HabitacionNormal(2);
		Habitacion h3 = new HabitacionNormal(3);
		unLaberinto.anadirHabitacion(h1);
		unLaberinto.anadirHabitacion(h2);
		unLaberinto.anadirHabitacion(h3);
		
		System.out.println("Creadas habitaciones Laberinto normal");
		Puerta laPuerta = laberinto.fabricarPuerta(h1, h2);
		Puerta laPuerta2 = laberinto.fabricarPuerta(h1, h2);
		h1.establecerLado(Direccion.NORTE, laberinto.fabricarPared());
		h1.establecerLado(Direccion.ESTE, laPuerta);
		h1.establecerLado(Direccion.SUR, laberinto.fabricarPared());
		h1.establecerLado(Direccion.OESTE, laberinto.fabricarPared());
		
		
		h2.establecerLado(Direccion.NORTE, laberinto.fabricarPared());
		h2.establecerLado(Direccion.ESTE, laberinto.fabricarPared());
		h2.establecerLado(Direccion.SUR, laPuerta2);
		h2.establecerLado(Direccion.OESTE, laPuerta);
		
		h3.establecerLado(Direccion.NORTE, laPuerta2);
		h3.establecerLado(Direccion.ESTE, laberinto.fabricarPared());
		h3.establecerLado(Direccion.SUR, laberinto.fabricarPared());
		h3.establecerLado(Direccion.OESTE, laberinto.fabricarPared());
		
		return unLaberinto;	
	}
	
	public Laberinto crearLaberinto2(FabricaAbstractaLaberintos laberinto){
		Laberinto unLaberinto2 = new Laberinto(1);
		Habitacion h1 = new HabitacionNormal(1);
		Habitacion h2 = new HabitacionNormal(2);
		Habitacion h3 = new HabitacionNormal(3);
		unLaberinto2.anadirHabitacion(h1);
		unLaberinto2.anadirHabitacion(h2);
		unLaberinto2.anadirHabitacion(h3);
		
		System.out.println("Creadas habitaciones Laberinto con Puerta Bomba ");
		Puerta laPuerta = laberinto.fabricarPuerta(h1, h2);
		Puerta laPuerta2 = laberinto.fabricarPuertaBomba(h1, h2);
		h1.establecerLado(Direccion.NORTE, laberinto.fabricarPared());
		h1.establecerLado(Direccion.ESTE, laPuerta);
		h1.establecerLado(Direccion.SUR, laberinto.fabricarPared());
		h1.establecerLado(Direccion.OESTE, laberinto.fabricarPared());
		
		
		h2.establecerLado(Direccion.NORTE, laberinto.fabricarPared());
		h2.establecerLado(Direccion.ESTE, laberinto.fabricarPared());
		h2.establecerLado(Direccion.SUR, laPuerta2);
		h2.establecerLado(Direccion.OESTE, laPuerta);
		
		h3.establecerLado(Direccion.NORTE, laPuerta2);
		h3.establecerLado(Direccion.ESTE, laberinto.fabricarPared());
		h3.establecerLado(Direccion.SUR, laberinto.fabricarPared());
		h3.establecerLado(Direccion.OESTE, laberinto.fabricarPared());
		
		return unLaberinto2;
	}
	
	public static void main(String[] args) {
/*		// TODO Auto-generated method stub
		//ArrayList<Habitacion> yyy = new ArrayList<Habitacion>();
		System.out.println("Creamos un laberinto del juego");
//		JuegoDelLaberinto laberinto = new JuegoDelLaberinto();
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
		
		laberintoBomba.getHabitaciones().get(0).Entrar(Lemi2); //Quitar el segundo campo del metodo entrar
		laberintoBomba.getHabitaciones().get(0).Entrar(Gilgamesh);
		System.out.println("");
		System.out.println("");
		Lemi2.move(Direccion.ESTE, laberintoBomba.getHabitaciones().get(0));
		Lemi2.move(Direccion.OESTE, laberintoBomba.getHabitaciones().get(0));
		Lemi2.move(Direccion.ESTE, laberintoBomba.getHabitaciones().get(1));
		*/
		
		FabricaAbstractaLaberintos labe;
		FabricaAbstractaLaberintos labe2;
		labe = new JuegoDelLaberintoNormal();
		CanalEmisora canal = new CanalEmisora();
		CanalEmisora canal2 = new CanalEmisora();
		CanalEmisora canal3 = new CanalEmisora();
		
		Laberinto laberintoDos = crearLaberinto(labe);
		
		System.out.println("Creando personajes");
		Character Lemi = new Lemming("Lemi",new DownArmsBehaviour());
		Character TioMalo = new BadLemming("TioMalo",new CatchBehaviour());

		
		//Insertamos personajes
		System.out.println("Insertamos los personajes en nuestro mapa");
		laberintoDos.situarCharacter(2, Lemi);
		laberintoDos.situarCharacter(3, TioMalo);
		Location location = Lemi.getLocation();
		System.out.println("Mapa: " + location.getMap() + " Habitacion: " +  location.getHabitacion());
		
		canal2.registra(Lemi);
		canal2.registra(TioMalo);
		
		
		Lemi.envia(canal2,"TioMalo", "ATACA!");
		TioMalo.envia(canal2, "Lemi", "AL ATAQUERRRR!!!");
		
		Location locationLem = Lemi.getLocation();
		Location locationTioMalo  = TioMalo.getLocation();
		
		Lemi.move(Direccion.NORTE, laberintoDos.numeroDeHabitacion(locationLem.getHabitacion()));
		Lemi.move(Direccion.SUR, laberintoDos.numeroDeHabitacion(locationLem.getHabitacion()));
		
//		labe2= new JuegoDelLaberinoConPuertasBomba();
//		Laberinto laberintoUNO = crearLaberinto(labe2);
		
		Ventana pantalla = new Ventana();
		pantalla.setSize(400,300);
		pantalla.setVisible(true);
		
		
	}

}
