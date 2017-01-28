package es.patron.estrategia.ull.es;

public class Main {
     
	public static void main(String[] args) {
		
		Robot r = new Robot(new AgressiveBehaviour());
		r.move();
		r.setBehaviour(new DefensiveBehaviour());
		r.move();
	}

}
