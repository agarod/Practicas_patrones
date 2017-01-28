package es.ull.patrones.Characters;

import es.ull.patrones.Comportamiento.IBehaviour;



public class Lemming extends Character{
	private IBehaviour m_Strategy;
	
	
	public Lemming(String name,IBehaviour m_Strategy) {
		super(name);
		this.m_Strategy = m_Strategy;
		
	}
	public void action(){
		m_Strategy.BehaveCommand();
	}

}






