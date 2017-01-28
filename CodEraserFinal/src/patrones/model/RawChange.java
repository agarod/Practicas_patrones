package patrones.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;

public class RawChange implements ICodificacion {
	
	final static int MAX = 122;
	final static int MIN = 48;
	String line= "";
	Integer line_value= 0;
	static RandomAccessFile fichero_;
	
	@Override
	public ArrayList<String> codificarArrayList(ArrayList<String> buffer) {
	
		String cadena = "";
		String line2 = "";
		
		ArrayList<String> buffer2 = new ArrayList();
		System.out.println("-------------------------");
		System.out.println(buffer);
		line2 = System.getProperty("line.separator");
		int numero = buffer.size();
		System.out.println(numero + "el numero de filas que tiene el buffer");
			
			for (int j = 0 ; j < buffer.size() ; j++){ 
		
				line = buffer.get(j);
				line_value = line.length();
				
				for( int i = 0 ; i < line_value ; i++ )
					cadena += getRandomChar();
				
				if ( j != buffer.size()-1)
					cadena += line2;
				
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
