package es.ull.patrones.Characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import Mediator.CanalEmisora;
import varios.CharacterStats;

public class Friendly extends Character {
    public Friendly(Animation up, Animation down, Animation left, Animation right,
            float x, float y, float colxOffset, float colyOffset, float colWidth, float colHeight, CharacterStats stats) {
        super(up, down, left, right, x, y, colxOffset, colyOffset, colWidth, colHeight, stats);
    }

    public Friendly(String pathName, int [] duration, float x, float y, float colxOffset, float colyOffset, float colWidth, float colHeight, CharacterStats stats) throws SlickException {
        super(pathName, duration, x, y, colxOffset, colyOffset, colWidth, colHeight, stats);
    }

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibe(String de, String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void envia(CanalEmisora mensaje, String de, String msg) {
		// TODO Auto-generated method stub
		
	}
}
