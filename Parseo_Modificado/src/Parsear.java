import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Parsear {
	
	private String separador = "(\\u0020)+"; // espacio http://stackoverflow.com/questions/4731055/whitespace-matching-regex-java
	private String[] cabeceras;
	private String enter = "\n";
	
	private ArrayList<String[]> datos = new ArrayList<String[]>();
	
	private int start_at = 6;
	
	private int cont = 0;
	private int cont_izq = 0;
	private int cont_der = 0;
	private String lin_aux;
	
	private String inputLine;
	

	public Parsear( String linea ){

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
		
		//System.exit(1);
		
	}
	
	void lectura(String linea){
		
		if( !linea.matches( separador )){
			
			System.out.println( linea );
			String[] partes;
			partes = linea.split( separador );
			datos.add( partes );
			
		}
		
	}
	
	
	public ArrayList<String[]> getDatos() {
		return datos;
	}


}