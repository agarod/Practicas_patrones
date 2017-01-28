import java.util.ArrayList;

public class ListadoPersona {
	private ArrayList <jugador> listadojugador;
	private ArrayList <Entrenador> listadoentrenador;
	public ListadoPersona(){
		listadojugador = new ArrayList <jugador>();
		listadoentrenador = new ArrayList<Entrenador>();
	}
	
	public void addEntrenador(Entrenador entrena){
		listadoentrenador.add(entrena);
	}
	public void addJugador(jugador profe){
		listadojugador.add(profe);
	}
	public void imprimir(){
		String temp = "";
		System.out.println("Listado de jugadores");
		System.out.println();
		for (jugador tmp: listadojugador) {
			System.out.println(tmp.toString());
			if (tmp instanceof JugadorSuplente){
				temp = "Suplente";
			}
			else {
				temp = "Titular";
			}
			System.out.println("Estado del jugador->"+temp);
		}
/*		for (Entrenador tmp1: listadoentrenador) {
			System.out.println(tmp1.toString()); 
		}*/
	}
}
