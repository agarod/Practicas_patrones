package es.ull.patrones.Algoritmo;

import java.util.ArrayList;

import es.ull.Problema.Problem;
import es.ull.Solucion.Solution;

public class MergeSort extends DivConqTemplate{
	private ArrayList<int[]> auxiliar = new ArrayList<int[]>();
	@Override
	protected boolean isSimple(Problem p) {
		// TODO Auto-generated method stub
		if (p.getDatos().size()==1){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	protected Solution simplySolve(Problem p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Problem[] decompose(Problem p) {
		// TODO Auto-generated method stub
		//return null;
		/*Mi codigo comienza aqui
		*/
		int tam_total = p.getDatos().size();
//		auxiliar = p.getDatos());
		int left = tam_total;
		int right = 0;
		int size = right - left + 1;
		int temp[] = new int[size];
		for (int i = 0; i < size; i++) {
			//temp[i] = auxiliar.get(left + i);
			temp[i] = p.getDatos().get(left+i);
		}
		//Changed positions in temp array.
		mid = mid - left;
		right = right - left;
		int k = left;
		int i = 0; // new left is (left - left) which is 0;
		int j = mid + 1;
		while (i <= mid && j <= right) {
			if (temp[i] <= temp[j]) {
				nums[k] = temp[i];
				i++;
			} else {
				nums[k] = temp[j];
				j++;
			}
			k++;
		}

		if (i > mid) {
			//copy remaining elements from right
			for (; j <= right; j++, k++) {
				nums[k] = temp[j];
			}
		} else {
			//copy remaining elements from left
			for (; i <= mid; i++, k++) {
				nums[k] = temp[i];
			}
		}

	}

	@Override
	protected Solution combine(Problem p, Solution[] ss) {
		// TODO Auto-generated method stub
		return null;
	}

}
