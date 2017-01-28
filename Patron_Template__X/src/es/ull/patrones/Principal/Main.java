package es.ull.patrones.Principal;

import es.ull.patrones.DivConq.DivConqTemplate;
import es.ull.patrones.DivConq.Problem;
import es.ull.patrones.Sort.Quicksort;



public class Main {
	private static Problem pr;
	public static void main(String[] args)  {
	/*	int valores[] = {20,42,3,41,50,3,6,11,14};
		int valor= 0;
		Vector vector=new Vector(valores.length, 5);
		valor = valores.length; */
		int valores[] = {20,42,3,41,50,3,6,11,14};
		
		Problem pr = new Problem() {
			int a[] = {10,40,1,5,9};
			int i =  0;
			int j = 4;
			int x = 10;
		};
		
		
		//pr.lectura(valores);
		
		//DivConqTemplate d = new Quicksort(valores);
		DivConqTemplate d = new Quicksort();
		d.solve(pr);
		
		
		
		
		
	}
	
}
