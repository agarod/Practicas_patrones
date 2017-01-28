package es.ull.patrones.Map;

import es.ull.patrones.Characters.Character;

public class PuertaBomba extends Puerta {

	public PuertaBomba(Habitacion habitacion1, Habitacion habitacion2) {
		super(habitacion1, habitacion2);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void Entrar(Character personaje) {
		System.out.println(personaje.getNombre()+"TIC..TAC...TIC...TAC...Has activado la bomba");
	}
	
	public boolean isEstaAbierta() {
		return estaAbierta;
	}

	public void setEstaAbierta(boolean estaAbierta) {
		this.estaAbierta = estaAbierta;
	}

}
