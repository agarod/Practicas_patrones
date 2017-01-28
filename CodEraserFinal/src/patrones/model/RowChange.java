package patrones.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
/*
 * Selecciona aleatoriamente un número de las lineas que tiene el documento
 * y la cambia por la linea que se esta leyendo, alterando el orden de lo escrito en el documento
 */
public class RowChange implements ICodificacion {
	
	final static int MAX = 122;
	final static int MIN = 48;
	String line= "";
	Integer line_length = 0;
	static RandomAccessFile fichero_;
	
	@Override
	public ArrayList<String> codificarArrayList(ArrayList<String> buffer) {
	
		String cadena = "";
		String saltolinea = "";
		String line3 = "";
		
		ArrayList<String> buffer2 = new ArrayList();
		Integer auxiliarAleatorio;
		ArrayList<Integer> numeroAleatorio = new ArrayList();
		System.out.println("-------------------------");
		System.out.println(buffer);
		saltolinea = System.getProperty("line.separator");
		int numero = buffer.size();
		System.out.println(numero + "el numero de filas que tiene el buffer");
		
		for (int i = 0; i <numero ; i++){
			 auxiliarAleatorio = Random(0, numero-1);
			 numeroAleatorio.add(auxiliarAleatorio);
		}
			
			for (int j = 0 ; j < buffer.size() ; j++){ 
		
				line = buffer.get(j);
				line3 = buffer.get(numeroAleatorio.get(j));
				line_length = line.length();

						
				if ( j != buffer.size()-1){
				
					cadena = line3;
					cadena += saltolinea;
				}
				
					//cadena = cadena.toString();
				
				buffer2.add(cadena);

				cadena = "";
			}
		
//		buffer2.remove(buffer2.size()-1);
		return buffer2;
	}
	
	public static char getRandomChar()
	{
		return (char)Random( MIN , MAX );
	}
	
	public static int Random (int min, int max){
		Random rnd = new Random();
		int aux_rnd = rnd.nextInt((max -min) +1 ) + min;
		return aux_rnd;
	}


}
