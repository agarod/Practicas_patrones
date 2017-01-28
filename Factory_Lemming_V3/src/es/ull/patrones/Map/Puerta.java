package es.ull.patrones.Map;

import es.ull.patrones.Characters.Character;
import es.ull.patrones.Map.ILugarDelMapa;

public abstract class Puerta implements ILugarDelMapa {
	
	private Habitacion habitacion1;
	private Habitacion habitacion2;
	private boolean estaAbierta = true;
	
	public Puerta(){}
	
	public final Habitacion otroLadoDe(Habitacion habitacion){
		if(habitacion.equals(habitacion1))
			return habitacion1;
		else
			return habitacion2;
		//Comprobar en que lado de la habitación se encuentra y devolver la otra habitación
	}
	
	@Override
	public void Entrar() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public abstract void Entrar(Character character);
	
	public void sentidoPuerta(Habitacion hab_origin, Habitacion hab_final, Character character){
		hab_origin.Salir(character);
		hab_final.Entrar(character);
	}

	@Override
	public void Entrar(Direccion direccion) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEstaAbierta() {
		return estaAbierta;
	}

	public void setEstaAbierta(boolean estaAbierta) {
		this.estaAbierta = estaAbierta;
	}
}