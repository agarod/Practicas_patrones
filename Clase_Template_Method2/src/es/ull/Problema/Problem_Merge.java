package es.ull.Problema;

import java.util.ArrayList;

public class Problem_Merge implements Problem {
	private ArrayList<int[]> datos = new ArrayList<int[]>();
	
	
	@Override
	public ArrayList<int[]> getDatos() {
		// TODO Auto-generated method stub
		return datos;
	}

	@Override
	public void volcado_datos(int[] vector) {
		// TODO Auto-generated method stub
		datos.add(vector);
	}

}
