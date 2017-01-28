package Representacion;
import java.util.ArrayList;
import java.util.Observable;


public class RepresentacionGrafica implements IRepresentacion {

//	public void representacion(ArrayList<String[]> datos, String Title,
//			String SubTitle, String RedLine) {
//		//JFreeChartXY chart = new JFreeChartXY("Tabla", "Datos de lluvia",datos);
//		JFreeChartXY chart = new JFreeChartXY(Title, SubTitle,datos,RedLine);
//	    chart.pack();
//	    chart.setVisible(true);
//		
//	}
	@Override
	public void representacion(ArrayList<String[]> datos, String Title,
			String SubTitle, String RedLine) {
		// TODO Auto-generated method stub
		JFreeChartXY chart = new JFreeChartXY(Title, SubTitle,datos,RedLine);
	    chart.pack();
	    chart.setVisible(true);
	}

	
}
