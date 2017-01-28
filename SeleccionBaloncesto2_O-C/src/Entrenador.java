
public class Entrenador extends persona {
	 private int idFederacion;
	 
	public Entrenador(String nombre, String apellidos){
		super(nombre,apellidos);
	}
	
	@Override
	public void entrenamiento() {
	   System.out.println("Realiza un entrenamiento (Clase Futbolista)");
	}

}
