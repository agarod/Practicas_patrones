package es.ull.patrones.Map;


import es.ull.patrones.Characters.Character;
import es.ull.patrones.Map.ILugarDelMapa;

public class Pared implements ILugarDelMapa {
	
	public Pared(){}
	
	@Override
	public void Entrar() {
		// TODO Auto-generated method stub
		System.out.println("Cabezazo contra la pared");
	}

	@Override
	public void Entrar(Character character) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Entrar(Direccion direccion) {
		// TODO Auto-generated method stub
		
	}

}