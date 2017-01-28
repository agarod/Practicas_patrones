package ejemplo.ull.patrones.es;

public class Suspendida implements EstadoVentanilla {

	@Override
	public void atende(Persona persona) {
		if (persona.getEdad() >65){
			System.out.println("Atendiendo a: " +persona.getNombre());
		}else {
			System.out.println("Espere 5 minutos por favor...");
		}
	}

}
