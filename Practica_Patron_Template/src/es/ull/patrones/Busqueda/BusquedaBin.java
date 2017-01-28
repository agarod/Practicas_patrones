package es.ull.patrones.Busqueda;

import es.ull.patrones.DivConq.DivConqTemplate;
import es.ull.patrones.DivConq.Problem;
import es.ull.patrones.DivConq.Solution;


public class BusquedaBin extends DivConqTemplate  {


	@Override
	protected boolean isSimple(Problem p) {
		
		return ( ((BusquedaBinDesc)p).getFirst() >= ((BusquedaBinDesc)p).getLast() );
		
	}

	@Override
	protected Solution simplySolve(Problem p) {
		// TODO Auto-generated method stub
		return (Solution) p;
	}

	@Override
	protected Problem[] descompose(Problem p) {
		int first = ((BusquedaBinDesc)p).getFirst();
		int search = ((BusquedaBinDesc)p).getSearch();
		int last = ((BusquedaBinDesc)p).getLast();
		int[] a = ((BusquedaBinDesc)p).getArr ();
		int mid = a[last/2]; //Mitad
		Problem[] ps = new BusquedaBinDesc[1];

		if (a[mid] > search){			
			ps[0] = new BusquedaBinDesc(a,first,mid-1,search);
			System.out.println("mid"+mid+" es mas grande que "+search);
			return ps;
		}
		if (a[mid]< search){
			 System.out.println("mid"+mid+" es mas pequeño que "+search);
			ps[0] = new BusquedaBinDesc(a,mid+1,last,search);
			return ps;
		}
		else{
			System.out.println("encontrado->"+search+" se encuentra en el array");
			ps[0] = new BusquedaBinDesc(a,mid,mid,search);
			return ps;
		}
		
	}

	@Override
	protected Solution combine(Problem p, Solution[] ss) {
		// TODO Auto-generated method stub
		return (Solution) p;
	}

}
