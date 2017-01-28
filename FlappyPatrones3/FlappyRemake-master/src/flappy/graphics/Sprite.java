package flappy.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import flappy.Constants;

public class Sprite {
	
	private String path;
	private Image spriteImage;
	
	public Sprite(String spritePath) {
		this.path = Constants.SPRITE_BASE + spritePath;
		try {
			this.spriteImage = new Image(this.path);
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}
	
	public int getWidth() {
		return this.spriteImage.getWidth();
	}
	
	public int getHeight() {
		return this.spriteImage.getHeight();
	}
	
	public Image getSprite() {
		return this.spriteImage;
	}
}
