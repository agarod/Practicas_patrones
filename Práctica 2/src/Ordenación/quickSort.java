package Ordenación;

public class quickSort {

	/**
	 * @param args
	 */
	public static void quickSort(int[] a,int prim, int ult){
        if(prim<ult){
            //Genero subconjuntos
            int l=pivote(a,prim,ult);
            //Aplico recursión sobre los subconjuntos
            if(l>prim){quickSort(a,prim,l-1);}
            if(l<ult){quickSort(a,l+1,ult);}
       }//Caso base prim=ult
	}
	/**
     * Devuelve la posición del pivote, elemento que por la izquierda solo
     * tiene elementos de valor inferior y por la derecha de valor superior.
     * Sobra decir que lo que hace es colocar los elementos a derecha o
     * del pivote según su valor.
     */
    private static int pivote(int[] a,int prim, int ult){
           int i=prim+1;
           int l=ult;
           int aux = 0;
           while(a[i]<=a[prim] && i<ult){i++;}
           while(a[l]>a[prim]){l--;}
           while(i<l){
               //intercambia(a,i,l);
               aux = a[i];
               a[i] = a[l];
               a[l] = aux;
               while(a[i]<=a[prim]){i++;}
               while(a[l]>a[prim]){l--;}
           }
           aux = a[prim];
           a[prim] = a[l];
           a[l] = aux;
           //intercambia(a,prim,l);
           return l;
    }
    
    public static int BusqBin(int[] a,int i, int j, int x){
    	int k = (i + j) /2;
        if (i > j)
        	return -1;
        else if (a[k] == x)
        		return k;
        if (x > a[k])
        	return BusqBin(a, k+1, j, x);
        else
        	return BusqBin(a, i, k-1, x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {10,40,1,5,9};
		
		//quickSort(a, a[0], a[4]);
		int busqBin = BusqBin(a, 0,4,10);
		
			System.out.println(busqBin);
		
	}

}
