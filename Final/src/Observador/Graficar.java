package Observador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Graficar implements Observer{

	
	private Observer observable;

	public void GraficoDibujo (Observer observable, ArrayList<String> cabecera,	ArrayList<ArrayList<Double>> datos) {
		
		this.observable = observable;

		String  titulo_grafico;
        Integer pos_x=999999, pos_y=999999;
		Scanner entradaEscaner = new Scanner (System.in);
		
		System.out.println("Titulo del grafico:");
		titulo_grafico = entradaEscaner.nextLine();
		
	
		
		// Recogemos los datos
		System.out.println("Que datos quiere pintar:");
		System.out.println("-->Opción Disponibles \n ");
		// Mostramos las cabeceras
		for (int i=0; i<cabecera.size(); i++) {
			
			System.out.println("-->Opción " + i + ": " + cabecera.get(i));
		}
		
		
		// Coordenada X
		do {
			
			System.out.print("eje X: ");
			pos_x = entradaEscaner.nextInt();
			
			// Controlamos el error
			if (! (pos_x >=0 && pos_x<cabecera.size()) ) {
				System.out.println("----> ERROR: Opcion inválida");
			}
			else {
				break;					
			}
			
		}while(true);
		
		
		// Coordenada Y
		do {
			
			System.out.print("eje Y: ");
			pos_y = entradaEscaner.nextInt();
			
			// Controlamos el error
			if (! (pos_y >=0 && pos_y <cabecera.size())) {
				System.out.println("----> ERROR: Opcion inválida");
			}
			else if(pos_x == pos_y) {
				System.out.println("----> ERROR: los valores de X e Y no pueden ser los mismos");
			}
			else {
				break;
			}
			
		}while(true);			
			
		
		
		// Creamos el Gráfico XY con los datos
		XYSeries series = new XYSeries("XYGraph");

		
		// Rellenamos el gráfico
		for(int i=0; i<datos.get(pos_x).size(); i++) {
			
			// Carga en gráfico
			series.add(datos.get(pos_x).get(i), datos.get(pos_y).get(i));
			
			// Muestra por consola
			System.out.println(datos.get(pos_x).get(i) + 
					"  " + datos.get(pos_y).get(i));
			
		}
		
			
		// Añadimos las series al dataset
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		
		
		// Generamos el gráfico
		JFreeChart chart = ChartFactory.createXYLineChart(
				titulo_grafico, // Title
				cabecera.get(pos_x), // x-axis Label
				cabecera.get(pos_y), // y-axis Label
				dataset, // Dataset
				PlotOrientation.VERTICAL, // Plot Orientation
				false, // Show Legend
				true, // Use tooltips
				false // Configure chart to generate URLs?
		);
		
		ChartFrame frame = new ChartFrame ("JFreeChart",chart);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	// Muestra en modo texto la información
	public void TextoXY(Observer observable, ArrayList<String> cabecera,	ArrayList<ArrayList<Double>> datos) {
		
		this.observable = observable;
		((Observable) this.observable).addObserver(this);
		
		Scanner entradaEscaner = new Scanner (System.in);
        Integer pos_x=999999, pos_y=999999;
		
		// Recogemos los datos
		System.out.println("Indique los datos que desea representar:");
		
		// Mostramos las cabeceras
		for (int i=0; i<cabecera.size(); i++) {
			System.out.println("-->Opción " + i + ": " + cabecera.get(i));
		}
		
		
		// Coordenada X
		do {
			
			System.out.print("Opcion coordenada X: ");
			pos_x = entradaEscaner.nextInt();
			
			// Controlamos el error
			if (! (pos_x >=0 && pos_x<cabecera.size()) ) {
				System.out.println("----> ERROR: Opcion inválida");
			}
			else {
				break;					
			}
			
		}while(true);
		
		
		// Coordenada Y
		do {
			
			System.out.print("Opcion coordenada Y: ");
			pos_y = entradaEscaner.nextInt();
			
			// Controlamos el error
			if (! (pos_y >=0 && pos_y <cabecera.size())) {
				System.out.println("----> ERROR: Opcion inválida");
			}
			else if(pos_x == pos_y) {
				System.out.println("----> ERROR: Las coordenadas X e Y no pueden ser las mismas");
			}
			else {
				break;
			}
			
		}while(true);
		
		
		// Muestra por consola las cabeceras:
		System.out.println("Datos Seleccionados a representar:");
		System.out.println("X=" + cabecera.get(pos_x) + " Y=" +
				cabecera.get(pos_y));
		
		
		// Rellenamos el gráfico
		for(int i=0; i<datos.get(pos_x).size(); i++) {
			
			// Muestra por consola
			System.out.println(datos.get(pos_x).get(i) + 
					"  " + datos.get(pos_y).get(i));
			
		}		
		
	}


	@Override
	public void update(Observable arg0, Object arg1) {
				System.out.println("soy Actualizado");
	}
	
		
	}
