package general;
import java.util.ArrayList;
import java.util.Observable;


public class RepresentacionTexto implements Irepresentacion  {

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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
