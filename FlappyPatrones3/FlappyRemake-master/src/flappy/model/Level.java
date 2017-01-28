package flappy.model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.Graphics;

import flappy.Constants;
import flappy.FlappyBird;
import flappy.model.pillars.Pillar;
import flappy.model.pillars.PillarType;
import flappy.model.pillars.Pillars;
import flappy.model.pillars.PillarsFactory;

public class Level {

	private FlappyBird instance;
	private List<Pillars> pillars = new ArrayList<Pillars>();
	private int translate = 0;
	private long lastMovementTime;
	private Random rand;
	private PillarsFactory factory;
	
	
	public Level(FlappyBird bird) {
		this.rand = new Random();
		this.instance = bird;
		this.factory = new PillarsFactory(this.instance);
	}
	
	public void generateLevel() {
		this.pillars.clear();
		int x = Constants.START_DISTANCE;
		for (int i = 0; i < Constants.TOTAL_WORLD_PILLARS; i++) {
			PillarType type = this.getRandomPillar();
			this.pillars.add(this.factory.createPillars(x, type));
			x += 275;
		}
	}
	
	public void renderLevel(Graphics g) {
		for (Pillars p : this.pillars) {
			if (p.outOfScreen()) continue;
			p.renderPillars(g);
		}
	}
	
	public List<Pillars> getPillars() {
		return this.pillars;
	}
	
	public long getTime() {
		return this.lastMovementTime;
	}
	
	public int getTranslate() {
		return this.translate;
	}
	
	public void updateTranslate() {
		this.translate += Constants.TRANSLATE_SPEED_MOVE;
	}
	
	public void resetTranslate() {
		this.translate = 0;
	}
	
	public void updateSpeed(int delta) {
		if (delta >= 0 && delta <= 20) {
			Constants.TRANSLATE_SPEED_MOVE = 3;
		}
		else if (delta > 20 && delta <= 35) {
			Constants.TRANSLATE_SPEED_MOVE = 5;
		}
		else if (delta > 35 && delta <= 60) {
			Constants.TRANSLATE_SPEED_MOVE = 7;
		}
		else if (delta > 60) {
			Constants.TRANSLATE_SPEED_MOVE = 12;
		}
	}

	private PillarType getRandomPillar() {
		int random = rand.nextInt(PillarType.values().length);
		return PillarType.values()[random];
	}
	
	public void setTime() {
		this.lastMovementTime = System.currentTimeMillis();
	}
}
