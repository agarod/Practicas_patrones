package patron_fachada;


/*Prestemos atención a lo siguiente: la clase AgenteEncubierto recibo una Persona como parámetro en el constructor. Pero evidentemente el AgenteEncubierto no puede revelar ciertos datos sensibles como su apellido o dirección y por ello mismo tiene datos prefijados en sus getters.
Otros datos, como su edad no son problema, con lo cual devuelve la edad de la persona.
Funcionan de la siguiente manera: */

public class AgenteEncubierto {
	private Persona persona;
	
	public AgenteEncubierto(Persona persona){
		this.persona = persona;
	}
	
	public String getApellido(){
		return "Perez";
	}
	
	public String getDominicilio(){
		return "Av Independencia";
	}
	
	
}
