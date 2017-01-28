package patron_fachada;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		persona.setNombre("Juan");
		persona.setApellido("TROLOLO");
		
		System.out.println("Datos de la persona");
		System.out.println(persona.getNombre());
		
		
		System.out.println("Datos del agente:");
		
		AgenteEncubierto agente = new AgenteEncubierto(persona);
		System.out.println(agente.getApellido());
	}

}
