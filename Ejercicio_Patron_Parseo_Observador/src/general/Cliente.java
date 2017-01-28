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
		while (getOpcion() != 3){
			System.out.println("Opcion 1: http://www.metoffice.gov.uk/climate/uk/stationdata/oxforddata.txt ");
			System.out.println("Opcion 2: https://d2khazk8e83rdv.cloudfront.net/opendata/enorlment_by_gender_2012-2013_en_0.txt");
		
			Scanner io = new Scanner(System.in);
			setOpcion(io.nextInt());
			
			switch (getOpcion()) {
			case 1:
				IParsear tabla = new Web1(Acceso1.conexion(texto1));
				
				addObserver(tabla);
				
				RepGraf.representacion(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");
				RepTxt = new RepresentacionTexto();
				RepTxt.representacion(tabla.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");

				break;
			case 2:
				IParsear tabla2 = new Web2(Acceso1.conexion(texto2));
				addObserver(tabla2);
				RepGraf.representacion(tabla2.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");
				RepTxt = new RepresentacionTexto();
				RepTxt.representacion(tabla2.getDatos(), "Tabla", "Datos de Lluvia", "mm de Lluvia");
				break;

			default:
				break;
			}
		}
		
		Paneles panel;
		panel = new Paneles("Hola");
		panel.add("Titulo");
		panel.show();
		panel.setVisible(true);

	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		new Cliente();
	}

}
