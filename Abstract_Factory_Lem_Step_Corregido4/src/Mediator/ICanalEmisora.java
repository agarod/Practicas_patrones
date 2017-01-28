package Mediator;

import es.ull.patrones.Characters.Character;

public interface ICanalEmisora {
	public abstract void registra(Character participante);
	public abstract void envia (String de, String a, String msg);
	

}
