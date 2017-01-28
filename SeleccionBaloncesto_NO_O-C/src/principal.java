
public class principal {
	public static void main(String [] Args){
		JugadorSuplente pi1  = new JugadorSuplente("Jose","Hernandez Lopez", 0,0,0,0);
		JugadorSuplente pi2  = new JugadorSuplente("Antonio","Hernandez Lopez", 5,1,0,0);
		JugadorTitular pt1 = new JugadorTitular("Jose","Antunez Melero", 90,10,20,5);
		JugadorTitular pt2 = new JugadorTitular("Michael","Jordan", 90,11,21,15);
		JugadorTitular pt3 = new JugadorTitular("Magic","Johnson", 90,10,23,7);
		JugadorTitular pt4 = new JugadorTitular("Larry","Bird", 90,10,30,10);
		JugadorTitular pt5 = new JugadorTitular("Denny","Rodman", 90,10,20,8);
		ListadoJugador listadoprofesor = new ListadoJugador();
		listadoprofesor.addJugador(pt1);
		listadoprofesor.addJugador(pt2);
		listadoprofesor.addJugador(pt3);
		listadoprofesor.addJugador(pt4);
		listadoprofesor.addJugador(pt5);
		listadoprofesor.addJugador(pi1);
		listadoprofesor.addJugador(pi2);
		listadoprofesor.imprimir();
	}
}
