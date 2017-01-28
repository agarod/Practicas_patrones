package ejemplo.ull.patrones.es;

public class Abierta implements EstadoVentanilla {

	@Override
	public void atende(Persona persona) {
		System.out.println("Ateniendo a: " + persona.getNombre());

	}

}
