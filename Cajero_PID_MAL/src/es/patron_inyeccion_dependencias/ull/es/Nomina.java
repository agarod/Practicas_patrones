package es.patron_inyeccion_dependencias.ull.es;


public class Nomina {
	public static void main(String[] args) {
		
		String nombre = "Trolololo";
		String email = "trolololo@ardiel.com";

		Empleado Emp1 = new Empleado(null);
		Emp1.procesoMensajeria(nombre,email);

	}

}
