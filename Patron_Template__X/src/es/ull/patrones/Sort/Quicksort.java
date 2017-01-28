package es.ull.patrones.Sort;

import es.ull.patrones.DivConq.DivConqTemplate;
import es.ull.patrones.DivConq.Problem;
import es.ull.patrones.DivConq.Solution;

public class Quicksort extends DivConqTemplate implements Problem {
    int array[];
    int size;
 
  /* ESTO SE SUPONE QUE LO HARIA EN LECTURA 
   * 
   * public Quicksort(int n){
        size=n;
        //create array with size n+1
        array=new int[n+1];
        //asign value into the array
        for (int i=0;i<n;i++){
            array[i]=(int) Math.round(Math.random()*89+10);
        }
        //set the last element as big value
        array[n]=99999;
    }*/
    public Quicksort(){
    	
    }
  /*  public Quicksort(int[] vector){
    	//lectura(vector);
    }*/

	@Override
	protected boolean isSimple(Problem p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Solution simplySolve(Problem p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Problem[] descompose(Problem p) {
	/*	int i = p;
		int j = q + 1;
		// Get the pivot element from the middle of the list
		int pivot = array[p];
		// Divide into two lists
		do {
		// If the current value from the left list is smaller then the pivot
		// element then get the next element from the left list
			do {
				i++;// As we not get we can increase i
			} while (array[i] < pivot);
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			do {
				j--;// As we not get we can increase j
			} while (array[j] > pivot);
			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the values.
				if (i <j) {
					swap(i, j);
				}
			} while (i <j);
			//swap the pivote element and j th element
		    swap(p, j);
		return j;*/
		return null;
	}


	@Override
	protected Solution combine(Problem p, Solution[] ss) {
     /*   //exachage the elements
        int temp = array[p];
        array[p] = array[j];
        array[j] = temp;*/
		return null;
	}

/*	@Override
	public void lectura(int[] datos) {
		for (int i = 0; i < datos.length; i++){
			array[i] = datos[i];
			System.out.println(array[i]);
		}
		
		
	}*/
}
