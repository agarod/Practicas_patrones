
public class principal {
	public static void main(String [] Args){
		JugadorSuplente pi1  = new JugadorSuplente("Jose","Hernandez Lopez");
		JugadorSuplente pi2  = new JugadorSuplente("Antonio","Hernandez Lopez");
		JugadorTitular pt1 = new JugadorTitular("Jose","Antunez Melero");
		JugadorTitular pt2 = new JugadorTitular("Michael","Jordan");
		JugadorTitular pt3 = new JugadorTitular("Magic","Johnson");
		JugadorTitular pt4 = new JugadorTitular("Larry","Bird");
		JugadorTitular pt5 = new JugadorTitular("Denny","Rodman");
		Entrenador e1 = new Entrenador("John","Doe");
		ListadoPersona listadopersona = new ListadoPersona();
		listadopersona.addJugador(pt1);
		listadopersona.addJugador(pt2);
		listadopersona.addJugador(pt3);
		listadopersona.addJugador(pt4);
		listadopersona.addJugador(pt5);
		listadopersona.addJugador(pi1);
		listadopersona.addJugador(pi2);
		listadopersona.addEntrenador(e1);
		listadopersona.imprimir();
	}
}
