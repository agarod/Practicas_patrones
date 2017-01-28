package Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Acceder  {
	
	public static String conexion(String texto) {
		
		
		
		try {
			// Indicamos la URL donde nos conectamos
			URL url = new URL(texto);
			// Buffer con los datos recibidos
			BufferedReader in = null;
			try {
				// Volcamos lo recibido al buffer
				in = new BufferedReader(new InputStreamReader(
						url.openStream()));
			} catch(Throwable t){}

			// Transformamos el contenido del buffer a texto
			String inputLine="";
			String inputText= "";

			while ( ( inputLine = in.readLine() ) != null ) 
			{				
			 inputText = inputText + inputLine + "\n";
			}
//			System.out.println(inputText);
		//	IParsear m_Parse = new Web1(inputText);

			in.close();
			//System.out.println(MD5.md5("123"));
			
			//System.exit(1);
			return inputText;
			
			
		} catch ( MalformedURLException me ) {
			System.out.println( "URL erronea" );
		} catch (IOException ioe) {
			System.out.println( "Error IO" );
		}
        return null;

	}


}