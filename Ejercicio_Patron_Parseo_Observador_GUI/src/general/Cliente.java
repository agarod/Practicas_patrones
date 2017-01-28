package general;

import java.io.IOException;
import java.util.Observable;
import java.util.Scanner;

import GUI.Paneles;

public class Cliente extends Observable {
	private static int opcion = 0;

	public int getOpcion() {
		return opcion;
	}
	
	public void setOpcion(int opcion) {
		Cliente.opcion = opcion;
		
		setChanged();
		notifyObservers();
		
	}
	
	
	public Cliente(){
		
		String texto2 = "https://d2khazk8e83rdv.cloudfront.net/opendata/enorlment_by_gender_2012-2013_en_0.txt";
		String texto1 = "http://www.metoffice.gov.uk/climate/uk/stationdata/oxforddata.txt";
		Acceder Acceso1 = new Acceder();
		Irepresentacion RepGraf;
		Irepresentacion RepTxt;
		RepGraf = new RepresentacionGrafica();

		while (getOpcion() != 4){
			System.out.println("Opcion 1: http://www.metoffice.gov.uk/climate/uk/stationdata/oxforddata.txt ");
			System.out.println("Opcion 2: https://d2khazk8e83rdv.cloudfront.net/opendata/enorlment_by_gender_2012-2013_en_0.txt");
			System.out.println("Opcion 3: abrir ventana");
			Scanner io = new Scanner(System.in);
			setOpcion(io.nextInt());
			IParsear tabla;
			//tabla = new Acceso1.conexion();
			
			switch (getOpcion()) {
			case 1:
				//IParsear tabla = new Web1(Acceso1.conexion(texto1));
				tabla = new Web1(Acceso1.conexion(texto1));
				addObserver(tabla);
				
				RepGraf.representacion(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");
				RepTxt = new RepresentacionTexto();
				RepTxt.representacion(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");

				break;
			case 2:
				//IParsear tabla2 = new Web2(Acceso1.conexion(texto2));
				tabla = new Web2(Acceso1.conexion(texto2));
				addObserver(tabla);
				RepGraf.representacion(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");
				RepTxt = new RepresentacionTexto();
				RepTxt.representacion(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");
				break;
				
			case 3:
				Paneles panel;
				
				panel = new Paneles("Hola");
				panel.add(tabla.getDatos(), "Titulo", "datos de lluvia","mm de LLuvia");
				panel.show();
				panel.setVisible(true);

			default:
				break;
			}
			
		
		}
		
//		Irepresentacion RepGraf;
//		Irepresentacion RepTxt;
//		Acceder Acceso1 = new Acceder();
//		IParsear tabla = new Web1(Acceso1.conexion(texto1));
//		
//		RepGraf = new RepresentacionGrafica();
//		RepGraf.representacion(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");
		//ESTE BORRAR
//		JFrame ventana;

		//Paneles panel;
		
	
//		
		//TACHADO PORMI
//		panel = new Paneles("Hola");
//		panel.add(tabla, "Titulo", texto1, texto1, null);
		//HASTA AQUI
//		
		//Añado esto
	//	Ventana1 panel;
	//	panel = new Ventana1(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de LLuvia");
		//Hasta aqui
		
		//TACHADO POR MI
//		panel.show();
//		panel.setVisible(true);
////		HASTA AQUI
		
		//ventana = new JFrame();
//		ventana.add(panel);
		
//		Paneles ventana = null;
//		ventana.add(RepGraf);
//		ventana.show();
//		
//		
//		RepTxt = new RepresentacionTexto();
//		RepTxt.representacion(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");
		
		
		//new representacion(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");
		
		//Acceder Acceso = new Acceder();
		//IParsear tabla2 = new Web2(Acceso.conexion(texto2));
	//	new representacion(tabla2.getDatos(), "Tabla", "Datos alumnos","Num_de alumnos");

	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		new Cliente();
	
	}

}
