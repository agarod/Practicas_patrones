package general;
import java.util.ArrayList;
import java.util.Observable;


public class Web2 implements IParsear {
//	private String separador = "(\\u0020)+"; // espacio http://stackoverflow.com/questions/4731055/whitespace-matching-regex-java
	private String[] cabeceras;
//	private String separador2 = "([|](\\u0020))";
	private String separador2= "|";

	
	private ArrayList<String[]> datos = new ArrayList<String[]>();
	
	private int start_at = 6;
	
	private String lin_aux;
	
	private String inputLine;
	
	public Web2(String linea) {
		
	//	System.out.println(linea);

		String[] lineas;
		lineas = linea.split("\n");

		for( int i = 0 ; i < lineas.length ; i++ )
		{
			//System.out.println(lineas[i]);
			if( i == 0 ){

				cabeceras = lineas[i].split(separador2);
				//System.out.println(cabeceras[i]);

			}

			else{
				
				lectura(lineas[i]);

			}
		}
	}



	@Override
	public void lectura(String linea) {
		if( !linea.matches( separador2 )){

			System.out.println( linea );
			String[] partes;
			partes = linea.split( separador2 );
			datos.add( partes );

		}

	}

	@Override
	public ArrayList<String[]> getDatos() {
		return datos;
	}



	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("Recibe la señal a Web2");	
//		System.exit(1);
	}


}
