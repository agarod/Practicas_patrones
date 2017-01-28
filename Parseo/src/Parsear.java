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
	
	private ArrayList<String[]> datos = new ArrayList<String[]>();
	
	private int start_at = 6;
	
	private String inputLine;
	
	public Parsear( String linea ){
	
		System.out.println(linea.split(separador));
		System.out.println("Chivato");
		cabeceras = linea.split( separador );
		
	}
	
	void lectura(String linea){
		if (linea.matches(separador)){
			
		}
		else{
			
		
		String[] partes;
		partes = linea.split(separador);
		datos.add( partes );
		}
		
	}
	
	
	public ArrayList<String[]> getDatos() {
		return datos;
	}


}




