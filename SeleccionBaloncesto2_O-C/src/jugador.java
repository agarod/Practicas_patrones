
public class jugador extends persona {
	//private tiros;
	//private asistencias;
	//private rebotes;
	
	jugador() {
		super();
	}
	public jugador(String nombre, String apellidos){
		super(nombre,apellidos);
	}

	public void mostrarDatos(){
		System.out.println("Datos del jugador. Nombre: " + getNombre()+""+getApellidos());
	}
	
	@Override
	public void entrenamiento(){
		System.out.println("Realiza un entrenamiento");
	}

}
