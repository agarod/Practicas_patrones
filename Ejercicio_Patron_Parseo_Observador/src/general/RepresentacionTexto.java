package general;
import java.util.ArrayList;


public class RepresentacionTexto implements Irepresentacion {

	@Override
	public void representacion(ArrayList<String[]> datos, String Title,
			String SubTitle, String RedLine) {
		String aux[];
		int TamVector = datos.size();
		for (int i = 0; i < TamVector; i++){
			aux = datos.get(i);
			System.out.println(aux[1]+" , "+aux[3]);
		}
		
		
			
			

	}

}
