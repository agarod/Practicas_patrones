package es.ull.patrones.Busqueda;

import es.ull.patrones.DivConq.Problem;
import es.ull.patrones.DivConq.Solution;

public class BusquedaBinDesc implements Problem, Solution {
	
	public BusquedaBinDesc(int[]arr, int first, int last, int search){
		this.arr = arr;
		this.first = first;
		this.last = last;
		this.search = search;
	}
	
	private int[] arr;
	private int first, last, search;
	
	public int getFirst () {return first;}
	public int getLast () { return last; }
	public int[] getArr() { return arr;}
	public int getSearch() {return search;}
	
}
