package es.ull.patrones.Map;

import es.ull.patrones.Characters.Character;

public class Pared implements LugarDelMapa {
	public Pared () {}
	@Override
	public void Entrar(Character personaje) {
		System.out.println(personaje.getNombre()+"Toca pared o lo que sea");
	}
	
	public Pared fabricarPared() {
		return new Pared();
	}
}

