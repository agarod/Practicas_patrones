
public abstract class jugador extends persona {
//	private String IdProfesor;
	public jugador(){
		super();
	}
	public jugador(String nombre, String apellidos, int edad, int asistencias, int rebotes, int tiros){
		super(nombre,apellidos, edad,asistencias, rebotes, tiros);
	}

	public void mostrarDatos(){
		System.out.println("Datos del jugador. Nombre: " + getNombre()+""+getApellidos());
	}

	
}
