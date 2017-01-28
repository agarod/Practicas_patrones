package es.ull.entregable2;

import java.util.ArrayList;


public class Pipe {
	private ArrayList<IPipe> pipe = new ArrayList<IPipe>();
	public void crearsocket(IPipe pipe) {
		this.pipe.add(pipe);
	}

}
