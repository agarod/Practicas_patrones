package es.ull.patrones.Characters;

import es.ull.patrones.Comportamiento.IBehaviour;



public class BadLemming extends Character{
	private IBehaviour m_Strategy;
	
	
	public BadLemming(String name, IBehaviour m_Strategy) {
		super(name);
		this.m_Strategy = m_Strategy;
		// TODO Auto-generated constructor stub
	}
	public void action(){
		m_Strategy.BehaveCommand();
	}

}