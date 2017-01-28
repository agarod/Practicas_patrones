import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class Acceder {
	private IParsear m_Parse;
	
	public IParsear conexion() {
		
		try {
			// Indicamos la URL donde nos conectamos
			URL url = new URL("https://d2khazk8e83rdv.cloudfront.net/opendata/enorlment_by_gender_2012-2013_en_0.txt");
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
			
			IParsear m_Parse = new Web2(inputText);

			in.close();
			return m_Parse;
			
			
		} catch ( MalformedURLException me ) {
			System.out.println( "URL erronea" );
		} catch (IOException ioe) {
			System.out.println( "Error IO" );
		}
        return null;

	}


}
