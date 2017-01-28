package flappy.model.pillars;

import java.awt.Graphics2D;

import org.newdawn.slick.Graphics;

import flappy.Constants;
import flappy.graphics.Sprite;

public class Pillar {

	private int x;
	private int y;
	private Sprite s;
	private int width;
	private int height;
	private Sprite end;
	private boolean isBottom;
	
	public Pillar(int x, int y, int height, Sprite s, Sprite s1, boolean bottom) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.height = height;
		this.width = s.getWidth();
		this.end = s1;
		this.isBottom = bottom;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Sprite getEnd() {
		return this.end;
	}
	
	public int getEndX() {
		return this.x - 1;
	}
	
	public int getEndY() {
		return this.y + this.height;
	}
	
	public void render(Graphics g) {
		g.drawImage(this.s.getSprite().getScaledCopy(this.width, this.height), this.x, this.y);
		g.drawImage(this.end.getSprite(), this.x - 1, this.y + this.height);
	}

	public boolean checkCollision(int x, int y) {
		if (this.isBottom) {
			return (x >= this.x - Constants.BIRD.getWidth() && x <= this.x + this.width &&
					y >= this.y + this.height && y <= this.y ||
					x >= this.getEndX() - Constants.BIRD.getWidth()  && x <= this.getEndX() + this.end.getWidth() &&
					y >= this.getEndY() - Constants.BIRD.getHeight() && y <= this.getEndY() + this.end.getHeight());			
		}
		return (x >= this.x - Constants.BIRD.getWidth() && x <= this.x + this.width &&
				y >= this.y - Constants.BIRD.getHeight() && y <= this.y + this.height ||
				x >= this.getEndX() - Constants.BIRD.getWidth() && x <= this.getEndX() + this.end.getWidth() &&
				y >= this.getEndY() - Constants.BIRD.getHeight() && y <= this.getEndY() + this.end.getHeight());

	}
	
	
}
