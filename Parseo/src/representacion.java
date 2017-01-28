import java.util.ArrayList;


public class representacion {
	
	representacion( ArrayList<String[]> datos ){
		 
		JFreeChartXY chart = new JFreeChartXY("Tabla", "Datos de lluvia",datos);
	    chart.pack();
	    chart.setVisible(true);
		
	
	}
}
