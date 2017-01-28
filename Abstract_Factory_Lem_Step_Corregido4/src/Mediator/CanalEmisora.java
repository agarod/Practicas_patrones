package Mediator;

import java.util.HashMap;
import es.ull.patrones.Characters.Character;

public class CanalEmisora implements ICanalEmisora {
	private HashMap <String, Character> participantes = new HashMap<String,Character>();
	
	@Override
	public void registra(Character participante) {
		// TODO Auto-generated method stub
		participantes.put(participante.getNombre(), participante);
	}

	@Override
	public void envia(String de, String a, String msg) {
//		// TODO Auto-generated method stub
		
		if( participantes.containsKey( de ) && participantes.containsKey( a ))
			System.out.println(msg);
		
		
		/*
		if (participantes.containsKey(de) && participantes.containsKey(a)){
			Character u = participantes.get(a);
			u.recibe(de, msg);
		} else{
			System.out.println("Usuario inexistente");
		}*/
		
	}



}
