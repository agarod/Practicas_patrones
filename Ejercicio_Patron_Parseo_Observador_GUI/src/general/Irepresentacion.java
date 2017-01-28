package general;
import java.util.ArrayList;
import java.util.Observer;


public interface Irepresentacion extends Observer {
	
	//void representacion();

	void representacion(ArrayList<String[]> datos, String Title,
			String SubTitle, String RedLine);
}
