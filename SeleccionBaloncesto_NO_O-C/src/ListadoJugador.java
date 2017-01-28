import java.util.ArrayList;

public class ListadoJugador {
	private ArrayList <jugador> listadojugador;
	public ListadoJugador(){
		listadojugador = new ArrayList <jugador>();
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
	}
}
