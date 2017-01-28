package ejemplo.ull.patrones.es;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona1 = new Persona("Juan","Perez", 21);
		
		Banco banco = new Banco();
		banco.atende(persona1);
		
		banco.suspendeVentanilla();
		
		//banco.atende(persona2);
		banco.cerraVentanilla();
		banco.atende(persona1);
	}

}
