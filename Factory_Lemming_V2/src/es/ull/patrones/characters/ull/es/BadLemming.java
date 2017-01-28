package es.ull.patrones.characters.ull.es;


import es.ull.patrones.movimientos.ull.es.IMove;


public class BadLemming {
	private IMove m_Moving;
	
	public BadLemming(IMove m_Moving) {
		this.m_Moving = m_Moving;
	}

	public void action(){
		m_Moving.movimiento();
	}
	
	public void setMove(IMove move){
		m_Moving = move;
	}

	public IMove getM_Moving() {
		return m_Moving;
	}

	
	
}
