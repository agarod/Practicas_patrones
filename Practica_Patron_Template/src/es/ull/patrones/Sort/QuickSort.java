package es.ull.patrones.Sort;

import es.ull.patrones.DivConq.DivConqTemplate;
import es.ull.patrones.DivConq.Problem;
import es.ull.patrones.DivConq.Solution;

public class QuickSort extends DivConqTemplate {

	@Override
	protected boolean isSimple(Problem p) {
		// TODO Auto-generated method stub
		return ( ((QuickSortDesc)p).getFirst() >= ((QuickSortDesc)p).getLast() );
	}

	@Override
	protected Solution simplySolve(Problem p) {
		// TODO Auto-generated method stub
		return (Solution) p ; 
	}

	@Override
	protected Problem[] descompose(Problem p) {
		// TODO Auto-generated method stub
		int first = ((QuickSortDesc)p).getFirst();
		int last = ((QuickSortDesc)p).getLast();
		int[] vector = ((QuickSortDesc)p).getArr ();
		int x = vector[first]; // pivot value
		int sp = first;
		for (int i = first + 1; i <= last; i++){
			if (vector[i] < x) {
				swap (vector, ++sp, i); 
			} 
		}
		swap (vector, first, sp);
		Problem[] ps = new QuickSortDesc[2];
		ps[0] = new QuickSortDesc(vector,first,sp-1);
		ps[1] = new QuickSortDesc(vector,sp+1,last);
		for (int i =0; i< vector.length; i++){
			System.out.print(vector[i]+" , ");
		}
		System.out.println("");
		return ps;

	}

	@Override
	protected Solution combine(Problem p, Solution[] ss) {
		// TODO Auto-generated method stub
		return (Solution) p; 
		
	}
	private void swap (int [] vector, int first, int last){ 
		int temp = vector[first];
		vector[first] = vector[last];
		vector[last] = temp;
		
	}
	
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
