package Sujeto;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class DatosClima  implements IParsear{
	
	
	
	public ArrayList<ArrayList<Double>> datos (ArrayList<String> data) {
		
		ArrayList<ArrayList<Double>> matriz = new ArrayList<ArrayList<Double>>();
		StringTokenizer content, content2;
		
		String valor, valor2;
		int columna;
		
		// Creamos la estructura de la matriz inicial sin las 7 primeras líneas 
		for (int i=0; i<7; i++) {
			matriz.add(new ArrayList<Double>());	
		}
		
		
		// Parseamos la información
		for (int i=7; i<data.size(); i++) {
			
			// Obtenemos linea a linea el contenido
			content = new StringTokenizer(data.get(i));
			columna = 0;
			
			
			// Mientras existan elementos
			while(content.hasMoreElements()) {
				
				// Obtenemos los valores 1 a 1
				valor = content.nextToken();
				
				// eliminamos los asteriscos
				content2 = new StringTokenizer(valor, "*");
				valor2 = content2.nextToken();
				
				
				// Almacenamos la información
				if (valor.equals("Provisional")) {
					break;
				}				
				else if (valor2.equals("---")) {
					matriz.get(columna).add(Double.NaN);			
				}
				else {
					matriz.get(columna).add(Double.parseDouble(valor2));
				}
		
				columna += 1;
			}
	
		}
			
		return matriz;
		
	}
	

	public ArrayList<String> Encabezado (ArrayList<String> data) {
		
		ArrayList<String> cabecera = new ArrayList<String>();
		StringTokenizer content;		
		
		// Obtenemos linea a linea el contenido
		content = new StringTokenizer(data.get(5));
			
		// Mientras existan elementos
		while(content.hasMoreElements()) {							
			cabecera.add(content.nextToken());			
		}
		
		return cabecera;
		
	}
	
		

	}
