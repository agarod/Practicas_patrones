package Modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Observable;

public class Url1 extends Observable{
	
	public ArrayList<String> Web (String Pagina)throws Exception { 
		
		// Conexion a la URL
        URL url = new URL(Pagina);
        URLConnection yc = url.openConnection();
        
        // Creamos el Buffer
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
        
        String inputLine;
        StringBuilder a = new StringBuilder();
    	ArrayList<String> data = new ArrayList<String>();
        
    	// Almacenamos la información
        while ((inputLine = in.readLine()) != null) {
        	data.add(inputLine.toString());
        }
        
        // Cerramos el Buffer
        in.close();
        
        System.out.println();
        System.out.println("Datos obtenidos de la web: " + Pagina);
        
        return data;
		
	}

}
