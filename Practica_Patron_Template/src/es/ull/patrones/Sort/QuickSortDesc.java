package es.ull.patrones.Sort;

import es.ull.patrones.DivConq.Problem;
import es.ull.patrones.DivConq.Solution;

public  class QuickSortDesc implements Problem, Solution
{ 
	public QuickSortDesc(int[]arr, int first, int last){ 
		this.arr = arr;
		this.first = first; this.last = last;
		
	}
	
	public int getFirst () {return first;}
	public int getLast () { return last; }
	private int[] arr;
	private int first, last;
	public int[] getArr () {return arr;}

	
	
	private static String printIntArr (int[] arr)
	    {   if (arr.length == 0) 
	        {   return "[]";   }
	        String outstr = "[" + arr[0];
	        int i = 1;
	        for( ; i < arr.length-1; i++)
	        {  outstr = outstr + "," + arr[i];   }
	        return (outstr + "]");
	    }
}



