package ejemplo.ull.patrones.es;

public class Persona {
	private String nombre;
	private String apellido;
	private int edad;
	
	public Persona(String ombre, String apellido, int edad){
		setApellido(apellido);
		setNombre(nombre);
		setEdad(edad);
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre= nombre;
	}
	
	public String getApellido(){
		return apellido;
	}
	
	public void setApellido(String apellido){
		this.apellido= apellido;
	}
	
	public Integer getEdad(){
		return edad;
	}
	
	public void setEdad(Integer edad){
		this.edad = edad;
	}
	
}
