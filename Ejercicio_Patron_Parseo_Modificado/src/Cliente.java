import java.io.IOException;


public class Cliente {
		
	
	public static void main(String[] args) throws IOException {
		Acceder A = new Acceder();
		IParsear tabla = A.conexion();
		
		new representacion(tabla.getDatos());
		
		
	}
}
