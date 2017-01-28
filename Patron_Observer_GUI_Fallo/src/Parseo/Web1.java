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


public class Web1 extends Observable implements IParsear {
	
	private String separador = "(\\u0020)+"; // espacio http://stackoverflow.com/questions/4731055/whitespace-matching-regex-java
	private String separador2 = "*";
	private String[] cabeceras;
	private String[] cabecerasxy;

	
	private ArrayList<String[]> datos = new ArrayList<String[]>();
	private ArrayList<Float[]> datosxy = new ArrayList<Float[]>();
	
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
		String[] aux;
		String valor;
		if( !linea.matches( separador )){
			
			System.out.println( linea );
			String[] partes;
			int j;
			partes = linea.split( (separador) );
			for (int i = 0; i< partes.length; i++){
				valor = partes[i];
				for (int k = 0; k< valor.length();k++){
					if (valor.charAt(k)=='*'){
						valor.replace("*","");
						partes[i] = valor.replace("*","");						
					}
				} 
			}
			datos.add( partes );
		}
	}

	@Override
	public ArrayList<String[]> getDatos() {
		// TODO Auto-generated method stub
		return datos;
	}


	@Override
    public boolean hasChanged() {
        super.hasChanged();
        return true; 
    }
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		String texto1 = "http://www.metoffice.gov.uk/climate/uk/stationdata/oxforddata.txt";
		System.out.println(arg1.toString());
		IParsear tabla;
		if (arg1.toString() == "http://www.metoffice.gov.uk" ) {
			
			tabla = new Web1(Acceder.conexion(texto1));
			
			IRepresentacion RepTexto= new RepresentacionTexto();
			IRepresentacion RepGrafica = new RepresentacionGrafica();
			ArrayList<String[]> copia = tabla.getDatos();
			
			XYSeries series = new XYSeries("XYGraph");
			String aux[];
			String aux2 = "";
			
			for (int i= 0; i < copia.size(); i++){
				aux = copia.get(i);
				series.add(Float.parseFloat( aux[3].replace( "*" , "" ) ) , Float.parseFloat( aux[6].replace( "*" , "" ) ) );
				aux2 = aux2 + aux[3]+"  ,  "+aux[6]+" ,  ";
			}
			
			XYSeriesCollection dataset = new XYSeriesCollection();
			dataset.addSeries(series);
								
			JFreeChart txtpnGrafico2 = ChartFactory.createXYLineChart("Grafico", "x", "y", dataset );
			
			ChartPanel txtpnGrafico = new ChartPanel(txtpnGrafico2);
			Dibujo seccionventana = new Dibujo();
			seccionventana.dibujargrafica(txtpnGrafico);
			seccionventana.escribirtexto(aux2);
		
		}

	}
	
	
}