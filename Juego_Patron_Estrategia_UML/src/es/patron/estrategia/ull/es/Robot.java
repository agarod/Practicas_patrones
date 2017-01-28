package es.patron.estrategia.ull.es;

import es.patron.estrategia.Behaviour.ull.es.IBehaviour;

public class Robot {
	private IBehaviour m_Strategy;
	
	public Robot(IBehaviour m_Strategy) {
		
		this.m_Strategy = m_Strategy;
	}
	public void robot(IBehaviour comp){
		
	}
	public void move(){
		m_Strategy.moveCommand();
	}
	
	public void setBehaviour(IBehaviour behave){
		m_Strategy = behave;
	}
}
