package es.ull.patrones.Contexto;

import es.ull.patrones.Characters.Character;
import es.ull.patrones.Comportamiento.IBehaviour;

import CharacterType.Elfo;
import CharacterType.Humano;
import CharacterType.Orco;
//import Characters.Character;
//import Interface.IBehaviour;
import Strategy.AgressiveBehaviour;
import Strategy.DefensiveBehaviour;
import Strategy.NormalBehaviour;

public class Contexto {
	public IBehaviour strategy(Character robot){
		IBehaviour strategy = null;
		if (robot.getFigth() >= 6){
			if (robot instanceof Orco){
				strategy = new AgressiveBehaviour();
			}
			else if (robot instanceof Elfo){
				strategy = new AgressiveBehaviour();
			}
			else if (robot instanceof Humano){
				strategy = new AgressiveBehaviour();
			}
		}
		else if (robot.getFigth() < -6){
			if (robot instanceof Orco){
				strategy = new DefensiveBehaviour();
			}
			else if (robot instanceof Elfo){
				strategy = new DefensiveBehaviour();
			}
			else if (robot instanceof Humano){
				strategy = new DefensiveBehaviour();
			}
		}
		else {
			if (robot instanceof Orco){
				strategy = new AgressiveBehaviour();
			}
			else if (robot instanceof Elfo){
				strategy = new DefensiveBehaviour();
			}
			else if (robot instanceof Humano){
				strategy = new NormalBehaviour();
			}
		}
		return strategy;
	}
	
}