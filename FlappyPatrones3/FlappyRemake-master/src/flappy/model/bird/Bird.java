package flappy.model.bird;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import flappy.Constants;
import flappy.FlappyBird;
import flappy.graphics.Sprite;
import flappy.model.pillars.Pillar;
import flappy.model.pillars.Pillars;

public class Bird {

	private int x;
	private int y;
	private Sprite bird = Constants.BIRD;
	private FlappyBird instance;
	private long lastMove;
	
	private boolean hasJumped = false;
	private boolean goingDown = false;
	private int pixelsToJump = 0;
	private int fallTime = 0;
	private long lastFall = System.currentTimeMillis();
	private double jumpSpeed = Constants.JUMP_RATE;
	private int birdAngle = Constants.BIRD_ANGLE;
	private long timeFall = 0;
	
	public Bird(int x, int y, FlappyBird instance) {
		this.x = x;
		this.y = y;
		this.instance = instance;
	}
	
	public Sprite getSprite() {
		return this.bird;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void move() {
		this.x += Constants.TRANSLATE_SPEED_MOVE;
		for (Pillars p : this.instance.getLevel().getPillars()) {
			Pillar a = p.getTop();
			Pillar b = p.getBottom();
			if (a.checkCollision(this.x, this.y) || b.checkCollision(this.x, this.y)) {
				this.lose();
			}
			else {
				if (this.x >= a.getX() && this.x <= a.getX() + a.getWidth()) {
					this.instance.updateSuccess();
				}
			}
		}
		if (this.y >= Constants.FLOOR) {
			this.lose();
		}
	}
	
	private void lose() {
		Constants.BIRD_MOVE = false;
		Constants.TRANSLATE = false;
		Constants.OVER = true;
		this.goingDown = true;
		this.instance.setShake();
		
	}
	
	public void render(Graphics g) {
		if (Constants.OVER) {
			g.drawImage(this.bird.getSprite(), this.x, this.y, new Color(1,1,1, 0.7f));
			return;
		}
		g.drawImage(this.bird.getSprite(), this.x, this.y);
	}

	private boolean goingUp;
	
	public void jump() {
		this.resetAngle();
		this.goingUp = true;
		this.goingDown = false;
		this.resetFall();
		this.pixelsToJump = 0;
		this.hasJumped = true;
		this.pixelsToJump += Constants.JUMP_DISTANCE;
		if (this.y - (Constants.JUMP_DISTANCE / 2) > 0) {
			this.y += -5;
		}
	}
	
	public void goingUp(boolean b) {
		this.goingUp = b;
	}
	
	public boolean isGoingUp() {
		return this.goingUp;
	}
	
	public void increaseAngle() {
		if (this.birdAngle < 345 || this.goingDown || this.y >= Constants.FLOOR) {
			return;
		}
		this.birdAngle -= 2;
	}
	
	private void resetFall() {
		this.goingDown = false;
		this.fallTime = 0;
		this.lastFall = 0;
	}
	
	public void setJumped() {
		this.hasJumped = false;
	}

	public boolean hasJumped() {
		return this.hasJumped;
	}
	
	public int getJumpSpeed(int delta) {
		return (int) this.jumpSpeed;
	}
	
	public void updateJumpSpeed(int delta) {
		if (this.pixelsToJump > 35) {
			this.jumpSpeed = 4;
		}
		if (this.pixelsToJump > 20 && this.pixelsToJump <= 35) {
			this.jumpSpeed = 3;
		}
		else if (this.pixelsToJump > 10 &&  this.pixelsToJump <= 20) {
			this.jumpSpeed = 2;
		}
		else if (this.pixelsToJump > 0 && this.pixelsToJump <= 10) {
			this.jumpSpeed = 1;
		}
			
	}
	
	public void updateAngle() {
		//if (this.jumpSpeed < 3) {
			if (this.goingUp || this.birdAngle > 450 || this.y >= Constants.FLOOR) {
				return;
			}
			this.birdAngle += 8;
		//}
	}
	
	private int getSpeedForDelta(int speed, int delta) {
		if (delta >= 0 && delta <= 20) {
			return speed;
		}
		else if (delta > 20 && delta <= 35) {
			return speed + 5;
		}
		else if (delta > 35 && delta <= 60) {
			return speed + 10;
		}
		else if (delta > 60) {
			return speed + 15;
		}
		return 1;
	}
	
	public int getJumpPixels() {
		return this.pixelsToJump;
	}
	
	public void updateJumpPixels(int amount) {
		this.pixelsToJump += amount;
	}
	
	public void setGoingDown() {
		this.goingDown = true;
		this.hasJumped = false;
	}

	public boolean goingDown() {
		return this.goingDown;
	}
	
	public void updateY(int y) {
		this.y += y;
	}
	
	public int getFallTime(int delta) {
		return this.fallTime * delta;
	}
	
	public void updateFallTime() {
		if (System.currentTimeMillis() - this.timeFall >= 17) {
			this.timeFall = System.currentTimeMillis();
			fallTime++;
		}
		if (this.fallTime > 10) {
			this.goingUp = false;
		}
		System.out.println("Fall time: " + this.fallTime);
	}
	
	public double getFallAmount(int delta) {
		return this.fallTime * Constants.FALL_RATE;
	}

	public void reset() {
		this.x = Constants.START_X;
		this.y = Constants.START_Y;
		this.hasJumped = false;
		this.goingDown = false;
	}

	public void updateAngleRotation() {
		this.bird.getSprite().setRotation(this.birdAngle);
	}

	public void resetAngle() {
		this.birdAngle = Constants.BIRD_ANGLE;
	}
}
