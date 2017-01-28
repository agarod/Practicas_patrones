package Main;
import es.ull.patrones.Busqueda.BusquedaBin;
import DyV.DivConqTemplate;
import DyV.Problem;
import DyV.Solution;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem pr = new Problem() {
			int a[] = {10,40,1,5,9};
			int i =  0;
			int j = 4;
			int x = 10;
		};
		DivConqTemplate d = new BusquedaBin();
		d.solve(pr);
	}

	

}
