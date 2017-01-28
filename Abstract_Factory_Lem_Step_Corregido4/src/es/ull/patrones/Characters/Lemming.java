package es.ull.patrones.Characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import varios.CharacterStats;
import Mediator.CanalEmisora;
import es.ull.patrones.Comportamiento.IBehaviour;



public class Lemming extends Character{
	private IBehaviour m_Strategy;
	private CanalEmisora mensaje;
	
	public Lemming(Animation up, Animation down, Animation left,
			Animation right, float x, float y, float colxOffset,
			float colyOffset, float colWidth, float colHeight, CharacterStats stats ) {
		super(up, down, left, right, x, y, colxOffset, colyOffset, colWidth, colHeight, stats);
		// TODO Auto-generated constructor stub
	}
	 public Lemming(String pathName, int [] duration, float x, float y, float colxOffset, float colyOffset, float colWidth, float colHeight,CharacterStats stats) throws SlickException {
	        super(pathName, duration, x, y, colxOffset, colyOffset, colWidth, colHeight,stats);
	 }
	
	public void action(){
		m_Strategy.BehaveCommand();
	}
	@Override
	public void recibe(String de, String msg) {
		// TODO Auto-generated method stub
		String s =/* de +*/ "dice: " + msg;
		System.out.println(de+ " " +s);
	}
	@Override
	public void envia(CanalEmisora mensaje, String a, String msg) {
		// TODO Auto-generated method stub
		mensaje.envia( super.getNombre() ,a, msg);
	
	}

}






