package es.ull.patrones.characters.ull.es;

import es.ull.patrones.comportamiento.ull.es.IBehaviour;
import es.ull.patrones.movimientos.ull.es.IMove;


public class Lemming {
	private IBehaviour m_Strategy;
	private IMove m_Moving;
	
	public Lemming(IBehaviour m_Strategy, IMove m_Moving) {
		
		this.m_Strategy = m_Strategy;
		this.m_Moving = m_Moving;
	}

	public void action(){
		m_Strategy.BehaveCommand();
		m_Moving.movimiento();
	}
	
	public void setBehaviour(IBehaviour behave, IMove move){
		m_Strategy = behave;
		m_Moving = move;
	}
	public void setMove(IMove move){
		m_Moving = move;
	}
	public IMove getM_Moving() {
		return m_Moving;
	}
	
}
