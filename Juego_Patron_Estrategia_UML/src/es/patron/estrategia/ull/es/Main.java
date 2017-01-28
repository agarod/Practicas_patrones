package es.patron.estrategia.ull.es;

import es.patron.estrategia.Behaviour.ull.es.AgressiveBehaviour;
import es.patron.estrategia.Behaviour.ull.es.DefensiveBehaviour;
import es.patron.estrategia.Behaviour.ull.es.NormalBehaviour;

public class Main {
     
	public static void main(String[] args) {
		
		Robot r = new Robot(new AgressiveBehaviour());
		Robot r2 = new Robot(new DefensiveBehaviour());
		r.move();
		r.setBehaviour(new DefensiveBehaviour());
		r.move();
		System.out.println("Robot 2");
		r2.move();
		r2.setBehaviour(new NormalBehaviour());
		r2.move();
	}

}
