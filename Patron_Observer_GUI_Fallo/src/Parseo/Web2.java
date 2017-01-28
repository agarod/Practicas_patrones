package Parseo;

import java.util.ArrayList;
import java.util.Observable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import GUI.Dibujo;
import Principal.Acceder;
import Representacion.IRepresentacion;
import Representacion.RepresentacionGrafica;
import Representacion.RepresentacionTexto;


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
	public void update(Observable arg0, Object arg1) {
		String texto2 = "https://d2khazk8e83rdv.cloudfront.net/opendata/enorlment_by_gender_2012-2013_en_0.txt";
		System.out.println(arg1.toString());
		IParsear tabla;
		if (arg1.toString() == "https://d2khazk8e83rdv.cloudfront.net" ) {
	
			tabla = new Web2(Acceder.conexion(texto2));
			
			IRepresentacion RepTexto= new RepresentacionTexto();
			IRepresentacion RepGrafica = new RepresentacionGrafica();
			ArrayList<String[]> copia = tabla.getDatos();
			
			XYSeries series = new XYSeries("XYGraph");
			String aux[];
			String aux2 = "";
			
			for (int i= 0; i < copia.size(); i++){
				aux = copia.get(i);
				series.add(Float.parseFloat( aux[3].replace( "*" , "" ) ) , Float.parseFloat( aux[6].replace( "*" , "" ) ) );
				aux2 =  aux2 + aux[3]+"  ,  "+aux[6]+" ,  ";
			}
			
			XYSeriesCollection dataset = new XYSeriesCollection();
			dataset.addSeries(series);
								
			JFreeChart txtpnGrafico2 = ChartFactory.createXYLineChart("Grafico", "x", "y", dataset  );
			
			ChartPanel txtpnGrafico = new ChartPanel(txtpnGrafico2);
			Dibujo seccionventana = new Dibujo();
			seccionventana.dibujargrafica(txtpnGrafico);
			seccionventana.escribirtexto(aux2);
		}
		
	}
}