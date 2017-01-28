package ejemplo.ull.patrones.es;

public class Cerrada implements EstadoVentanilla {

	@Override
	public void atende(Persona persona) {
		System.out.println("Ventanilla cerrada");
	}

}
