import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class Acceder {
	public Parsear conexion() {
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
			

			// Mientras haya cosas en el buffer las volcamos a las
			// cadenas de texto
			for (int i = 0; i < 6 ; i++)
				inputLine = in.readLine();
			
            Parsear parse = new Parsear( inputLine );

            in.readLine();

			
			while ( ( inputLine = in.readLine() ) != null ) 
			{
			 //inputText = inputText + inputLine + "\n";
	         parse.lectura(inputLine);
			
	         System.out.println( inputLine );
			
			}

			// Mostramos el contenido y cerramos la entrada
			//System.out.println("El contenido de la URL es: " +"\n"+ inputText);

			// System.out.println(st);
			in.close();
			return parse;
			
			
		} catch ( MalformedURLException me ) {
			System.out.println( "URL erronea" );
		} catch (IOException ioe) {
			System.out.println( "Error IO" );
		}
        return null;

	}


}
