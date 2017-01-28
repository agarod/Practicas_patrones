import java.net.*;
import java.util.ArrayList;

import java.util.StringTokenizer;
import java.io.*;
    
public class Acceso {
   public static void main(String[] args) {
        try {
              // Indicamos la URL donde nos conectamos
              URL url = new URL("http://www.metoffice.gov.uk/climate/uk/stationdata/oxforddata.txt");
              // Buffer con los datos recibidos
              BufferedReader in = null;
               
              try {
                // Volcamos lo recibido al buffer
                in = new BufferedReader(new InputStreamReader(
                   url.openStream()));
              } catch(Throwable t){}
	              // Transformamos el contenido del buffer a texto
              String inputLine="";
              String inputText="";

              // Mientras haya cosas en el buffer las volcamos a las
              // cadenas de texto
              for (int i = 0; i<7; i++)
                  in.readLine();
              ArrayList<StringTokenizer> anio = new ArrayList<StringTokenizer>();
              ArrayList<StringTokenizer> mes = new ArrayList<StringTokenizer>();
              ArrayList<StringTokenizer> tmax = new ArrayList<StringTokenizer>();
              ArrayList<StringTokenizer> tmin = new ArrayList<StringTokenizer>();
              ArrayList<StringTokenizer> af = new ArrayList<StringTokenizer>();
              ArrayList<StringTokenizer> rain = new ArrayList<StringTokenizer>();
              ArrayList<StringTokenizer> sun = new ArrayList<StringTokenizer>();

             // anio.add(st);
              
              
              while ((inputLine = in.readLine()) != null) 
              {
 //               inputText = inputText + inputLine + "\n";
            	  StringTokenizer st = new StringTokenizer(inputLine,"   ");
            	  anio.add(st);
            	  while(st.hasMoreTokens()) {
            		  
            	      mes.add(st);
            	      tmax.add(st);
            	      tmin.add(st);
            	      af.add(st);
            	      rain.add(st);
            	      sun.add(st);
            	    }
                  
              }
             // StringTokenizer st = new StringTokenizer(inputText);
              

	              // Mostramos el contenido y cerramos la entrada
	              System.out.println("El contenido de la URL es: " +"\n"+ inputText);
	              
 
	             // System.out.println(st);
	              in.close();
	              for (int i = 0;i<anio.size();i++){
	            	  System.out.println(anio);
	              }
	               
            } catch (MalformedURLException me) {
              System.out.println("URL erronea");
            } catch (IOException ioe) {
              System.out.println("Error IO");
        }
	            

     }

    
}
