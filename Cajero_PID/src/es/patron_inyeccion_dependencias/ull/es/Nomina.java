package es.patron_inyeccion_dependencias.ull.es;
import es.Inyeccion_Interfaces.ull.es.*;
import es.patron_inyeccion_dependencias.ull.es.*;

public class Nomina {
	public static void main(String[] args) {
		
		String nombre = "Trolololo";
		String email = "trolololo@ardiel.com";
		MensajeriaInjector injector = null;
		Empleado app = null;
		
		injector = new MensajeriaInjector();
        app = injector.getEmpleado();
        app.procesoMensajeria(nombre, email);
	}

}
