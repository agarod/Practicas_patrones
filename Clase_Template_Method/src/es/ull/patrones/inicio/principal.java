package es.ull.patrones.inicio;
import es.ull.patrones.vehiculo.*;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		excavadora caterpilar = new Picapica();
		caterpilar.desplazar();
		System.out.println("");
		excavadora Volvo = new Cuchara();
		Volvo.desplazar();	

	}

}
