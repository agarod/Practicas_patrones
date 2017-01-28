package ejemplo.ull.patrones.es;

public class Banco {
	private String nombre;
	private String direccion;
	private Ventanilla ventanilla;
	
	public Banco(){
		ventanilla = new Ventanilla();
	}
	
	public void atende(Persona persona){
		System.out.println(persona.getNombre() + "ingresa a la fila. ");
		ventanilla.atende(persona);
	}
	
	public void suspendeVentanilla(){
		ventanilla.suspendete();
	}
	
	public void cerraVentanilla(){
		ventanilla.cerrate();
	}
	
	public void abriVentanilla(){
		ventanilla.abrite();
	}
	
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre= nombre;
	}
	public String getDireccion(){
		return direccion;
	}
	
	public void setDireccion(String direccion){
		this.direccion= direccion;
	}
	
}
