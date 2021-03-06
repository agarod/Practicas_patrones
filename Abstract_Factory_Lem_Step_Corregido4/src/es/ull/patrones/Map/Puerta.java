package es.ull.patrones.Map;

import es.ull.patrones.Characters.Character;

public abstract class Puerta implements LugarDelMapa {
	private Habitacion habitacion1;
	private Habitacion habitacion2;
	protected boolean estaAbierta;  
	
	
	public Puerta(Habitacion habitacion1, Habitacion habitacion2) {}
	public final Habitacion otroLadoDe(Habitacion habitacion){
		if(habitacion.equals(habitacion1))
			return habitacion1;
		else
			return habitacion2;
		//Comprobar en que lado de la habitación se encuentra y devolver la otra habitación
	}

	@Override
	public abstract void Entrar(Character personaje);
	
	public boolean isEstaAbierta() {
		return estaAbierta;
	}

	public void setEstaAbierta(boolean estaAbierta) {
		this.estaAbierta = estaAbierta;
	}
}
