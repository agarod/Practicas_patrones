package es.ull.patrones.inicio;
import es.ull.patrones.Algoritmo.*;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivConqTemplate caterpilar = new Picapica();
		caterpilar.desplazar();
		System.out.println("");
		DivConqTemplate Volvo = new Cuchara();
		Volvo.desplazar();	

	}

}
