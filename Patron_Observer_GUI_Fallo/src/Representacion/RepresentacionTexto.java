package Representacion;



import java.util.ArrayList;
import java.util.Observable;

public class RepresentacionTexto implements IRepresentacion {

	@Override
	public void representacion(ArrayList<String[]> datos, String Title,
			String SubTitle, String RedLine) {
		String aux[];
		int TamVector = datos.size();
		for (int i = 0; i < TamVector; i++){
			aux = datos.get(i);
			System.out.println(aux[3]+" , "+aux[6]);
		}
	}


}

