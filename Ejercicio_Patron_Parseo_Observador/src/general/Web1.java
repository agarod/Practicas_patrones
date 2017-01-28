package general;
import java.util.ArrayList;
import java.util.Observable;


public class Web1 implements IParsear {
	
	private String separador = "(\\u0020)+"; // espacio http://stackoverflow.com/questions/4731055/whitespace-matching-regex-java
	private String[] cabeceras;

	
	private ArrayList<String[]> datos = new ArrayList<String[]>();
	
	private int start_at = 6;
	
	public Web1(String linea) {
		String[] lineas;
		lineas = linea.split("\n");
		
		for( int i = 0 ; i < lineas.length ; i++ )
		{
					
			if( i == 5 ){
				
				cabeceras = lineas[i].split(separador);
			
			}
			
			if( i < 7 ){
				System.out.println("");
			}else{
				lectura(lineas[i]);	
			}
		}
	}

	@Override
	public void lectura(String linea) {
		if( !linea.matches( separador )){
			//AQUI MUESTRO LINEA A LINEA
		//	System.out.println( linea );
			String[] partes;
			partes = linea.split( separador );
			datos.add( partes );
			
		}
	}

	@Override
	public ArrayList<String[]> getDatos() {
		
		return datos;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("Recibe la señal a Web1");
//		System.exit(1);
	}

	
	
}
