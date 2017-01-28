package general;
import java.util.ArrayList;


public class RepresentacionGrafica implements Irepresentacion {

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
