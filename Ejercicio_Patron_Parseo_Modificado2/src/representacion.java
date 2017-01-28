import java.util.ArrayList;


public class representacion {
	
	representacion( ArrayList<String[]> datos, String Title, String SubTitle,String RedLine ){
		 
		//JFreeChartXY chart = new JFreeChartXY("Tabla", "Datos de lluvia",datos);
		JFreeChartXY chart = new JFreeChartXY(Title, SubTitle,datos,RedLine);
	    chart.pack();
	    chart.setVisible(true);
		
	
	}
}
