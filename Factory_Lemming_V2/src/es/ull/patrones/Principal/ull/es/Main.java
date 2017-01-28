package es.ull.patrones.Principal.ull.es;

import java.util.Random;

import es.ull.patrones.characters.ull.es.BadLemming;
import es.ull.patrones.characters.ull.es.Lemming;
import es.ull.patrones.comportamiento.ull.es.DownArmsBehaviour;
import es.ull.patrones.comportamiento.ull.es.JumpBehaviour;
//import es.ull.patrones.comportamiento.ull.es.MinerBehaviour;
//import es.ull.patrones.movimientos.ull.es.MoveDerecha;
//import es.ull.patrones.movimientos.ull.es.MoveIzquierda;
import es.ull.patrones.movimientos.ull.es.*;


public class Main {

	public static void main(String[] args) {
		
		int espacio = 1;

		Lemming lem = new Lemming(new DownArmsBehaviour(), new MoveDerecha());
		BadLemming bad_lem = new BadLemming(new MoveDerecha());
		System.out.println("Lemming malo");
		bad_lem.action();
		System.out.println("Lemming bueno");
	
		lem.action();
		lem.setMove(new MoveDerecha());
		lem.action();
		
		for (int i= 0 ; i < 10; i++){
			Random rand = new Random();
			int DirBadLem = rand.nextInt(2);
			int DirLem = rand.nextInt(2);
			System.out.println("Lemming malo se mueve"+DirBadLem+" Lemming bueno se mueve "+DirLem);
			if (DirLem != DirBadLem){
				espacio--;
				if (espacio == 0){
					System.out.println("Se encuentran");
					bad_lem.setMove(new MoveIzquierda());
					lem.setBehaviour(new JumpBehaviour(), new MoveDerecha());
					lem.action();
					lem.setBehaviour(new DownArmsBehaviour(), new MoveDerecha());
					System.out.print("Lemming Malo =>");
					bad_lem.action();
					System.out.println("");
					System.out.print("Lemming Bueno =>");
					lem.action();
				}
				System.out.println("El espacio es..."+espacio);
				if ( espacio >0){
					
				}
				if (espacio < 0){
					
				}
			}
			
			else {
				espacio++;
				System.out.println("El espacio es___" +espacio);
			}
		}

	}
	
}
