package flappy.model.pillars;

import java.awt.Graphics2D;

import org.newdawn.slick.Graphics;

import flappy.Constants;
import flappy.FlappyBird;

public class Pillars {

	private Pillar top;
	private Pillar bottom;
	private FlappyBird instance;
	
	public Pillars(Pillar a, Pillar b, FlappyBird i) {
		this.top = a;
		this.bottom = b;
		this.instance = i;
	}
	
	public Pillar getTop() {
		return this.top;
	}
	
	public Pillar getBottom() {
		return this.bottom;
	}
	
	public void renderPillars(Graphics g) {
		this.top.render(g);
		this.bottom.render(g);
	}

	public boolean outOfScreen() {
		if (this.top.getX() - this.instance.getLevel().getTranslate() > Constants.WIDTH ||
				this.instance.getLevel().getTranslate() - this.top.getX() > 300) {
			return true;
		}
		return false;
	}

}
