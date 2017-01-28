package patron_fachada;

public class Persona {
	private String nombre;
	private String apellido;
	private int edad;
	private String dni;
	private String domicilio;
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido){
		this.apellido = apellido;
	}
	
}
