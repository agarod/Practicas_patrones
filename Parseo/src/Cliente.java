import java.io.IOException;


public class Cliente {
	public static void main(String[] args) throws IOException {
		Acceder A = new Acceder();
		Parsear tabla = A.conexion();
		new representacion(tabla.getDatos());
		
		
	}
}
