package flappy.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import flappy.Constants;
import flappy.FlappyBird;

public class Background {
	
	private class RepeatedBackground {
		
		private int x;
		
		public RepeatedBackground(int x) {
			this.x = x;
		}
		
		public int getX() {
			return this.x;
		}
		
		public void render(Graphics g) {
			Image sprite = new Sprite(Constants.BACKGROUND).getSprite();
			g.drawImage(sprite, this.x, 0);
		}
	}
	
	private FlappyBird game;
	private List<RepeatedBackground> repeats = new ArrayList<RepeatedBackground>();
	
	public Background(FlappyBird game) {
		this.game = game;
	}
	
	public void generateBackgrounds() {
		this.repeats.clear();
		int x = 0;
		for (int i = 0; i < Constants.BACKGROUND_WORLD_SIZE; i++) {
			this.repeats.add(new RepeatedBackground(x));
			x += Constants.BACKGORUND_SPRITE_WIDTH;
		}
	}
	
	private int shakeScreen;
	
	public void setShakeScreen(int shake) {
		this.shakeScreen = shake;
	}
	
	public int getShake() {
		return this.shakeScreen;
	}
	
	public void render(Graphics g) {
		Iterator<RepeatedBackground> itr = this.repeats.iterator();
		while (itr.hasNext()) {
			RepeatedBackground b = itr.next();
			if (this.game.getLevel().getTranslate() - b.getX() >= 300) {
				itr.remove();
				continue;
			}
			if (b.getX() - this.game.getLevel().getTranslate() < Constants.WIDTH) {
				b.render(g);
			}
		}
	}

}
