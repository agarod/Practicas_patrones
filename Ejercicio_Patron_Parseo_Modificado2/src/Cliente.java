import java.io.IOException;


public class Cliente {
		
	
	public static void main(String[] args) throws IOException {
		String texto2 = "https://d2khazk8e83rdv.cloudfront.net/opendata/enorlment_by_gender_2012-2013_en_0.txt";
		String texto1 = "http://www.metoffice.gov.uk/climate/uk/stationdata/oxforddata.txt";
	
		Acceder Acceso1 = new Acceder();
		IParsear tabla = new Web1(Acceso1.conexion(texto1));
		new representacion(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");
		
		Acceder Acceso = new Acceder();
		IParsear tabla2 = new Web2(Acceso.conexion(texto2));
		new representacion(tabla2.getDatos(), "Tabla", "Datos alumnos","Num_de alumnos");

		
	}
}
