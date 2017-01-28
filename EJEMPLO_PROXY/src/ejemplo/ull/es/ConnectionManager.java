package ejemplo.ull.es;

public class ConnectionManager {
	private static boolean hayConexion;
	
	public ConnectionManager() {
		hayConexion = false;
	}
	
	public static void conectate() {
		hayConexion = true;
	}
	
	public static void desconectate() {
		hayConexion = false;
	}
	
	public static boolean hayConexion(){
		return hayConexion;
	}
	
}
