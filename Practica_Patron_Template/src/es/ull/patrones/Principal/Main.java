package es.ull.patrones.Principal;

import java.util.Vector;

import es.ull.patrones.Busqueda.BusquedaBin;
import es.ull.patrones.Busqueda.BusquedaBinDesc;
import es.ull.patrones.DivConq.DivConqTemplate;
import es.ull.patrones.DivConq.Problem;
import es.ull.patrones.Sort.QuickSort;
import es.ull.patrones.Sort.QuickSortDesc;



public class Main {
	
	public static void main(String[] args)  {
		
		int valores[] = {10,40,1,5,9};
		int i = 0;
		int j = valores.length-1;
		
		Problem pr = new QuickSortDesc(valores, i, j);
		DivConqTemplate d = new QuickSort();
		d.solve(pr);
		System.out.println("");
		System.out.println("");
		
		
		int search_vector[] = {1,2,3,4,5,6};
		int ini = 0;
		int fin = search_vector.length-1;
		int search = 2;
		
		Problem pr2 = new BusquedaBinDesc(search_vector, ini, fin, search);
		DivConqTemplate d2 = new BusquedaBin();
		d2.solve(pr2);
		
	}	
		
	
	
}
