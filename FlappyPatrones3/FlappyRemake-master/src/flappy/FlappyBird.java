package flappy;

import java.awt.Font;

import flappy.graphics.Background;
import flappy.input.Keyboard;
import flappy.model.Level;
import flappy.model.bird.Bird;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class FlappyBird implements Game {
	
	private Level level;
	private Background background;
	private int successes = 0;
	private Bird myBird;
	private long successTime;
	private int shakeAmount = 0;
	private long shakeTime = 0;
	private int record = 0;
	private int oldRecord = 0;
	private Keyboard keyboard;
	private boolean newRecord = false;
	
	private TrueTypeFont recordFont;
	private TrueTypeFont points;
	
	private long time;
	private long restartTime;
	private boolean canRestart = false;
	private boolean shake = false;
	private boolean started = false;	
	
	/**
	 * Gets the bird object
	 * @return bird!
	 */
	
	public Bird getBird() {
		return this.myBird;
	}
	
	/**
	 * Gets the level object
	 * @return My level
	 */
	
	public Level getLevel() {
		return this.level;
	}

	/**
	 * {@link Bird#move()} updates at bird movement
	 * Updates Success count
	 */
	
	public void updateSuccess() {
		if (System.currentTimeMillis() - this.successTime >= 500 && !Constants.OVER) {
			this.successes++;
			if (this.successes > this.record) {
				this.record++;
				this.newRecord = true;
			}
			this.successTime = System.currentTimeMillis();
		}
	}

//	@Override
	public boolean closeRequested() {
		return true;
	}

//	@Override
	public String getTitle() {
		return null;
	}

	/**
	 * {@link Bird#move()} Shakes upon collision.
	 * Shakes the screen
	 */
	
	public void setShake() {
		this.shake = true;
	}
	
//	@Override
	public void init(GameContainer c) throws SlickException {
		if (c instanceof AppGameContainer) {
			((AppGameContainer) c).setTitle("Flappy birds! Remake for desktop tho");
		}
		this.background = new Background(this);
		this.background.generateBackgrounds();
		this.level = new Level(this);
		this.level.generateLevel();
		this.myBird = new Bird(Constants.START_X, Constants.START_Y, this);
		this.keyboard = new Keyboard(this);
		Font font = new Font("Verdana", Font.BOLD, 40);
		this.recordFont = new TrueTypeFont(font, false);
		Font font1 = new Font("Arial", Font.BOLD, 72);
		this.points = new TrueTypeFont(font1, false);		
		
	}

//	@Override
	public void render(GameContainer c, Graphics g) throws SlickException {
		
		if (this.shake && Constants.OVER) {
			g.translate(background.getShake(), 0);
		}
		g.translate(-this.level.getTranslate(), 0);	
		this.background.render(g);
		this.level.renderLevel(g);
		this.myBird.render(g);
		g.translate(this.level.getTranslate(), 0);
		g.drawString("Record: " + this.oldRecord, 5, 5);
		this.points.drawString(333, 15, "" + this.successes);
		if (!this.started) {
			g.setColor(new Color(0, 0, 0, 0.5f));
			g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
			g.setColor(Color.white);
			g.drawString(Constants.START_MESSAGE,
					(int)(Constants.WIDTH / 2.44) - Constants.START_MESSAGE.length(),
					(Constants.HEIGHT / 2) - 15);
			
		}	
		if (Constants.OVER && this.newRecord) {
			this.recordFont.drawString(195,  200, "NEW RECORD!");
		}
		
	}
	
//	@Override
	public void update(GameContainer c, int delta) throws SlickException {
		this.keyboard.handleInput(c);
		if (!this.started)
			return;
		if (Constants.OVER) {
			c.getInput().clearKeyPressedRecord();
		}
		if (Constants.OVER && System.currentTimeMillis() - this.shakeTime >= 30 && this.shake) {
			this.background.setShakeScreen(this.background.getShake() == 2 ? -2 : 2);
			this.shakeAmount++;
			this.shakeTime = System.currentTimeMillis();
			if (this.shakeAmount > 10) {
				this.shake = false;
				this.restartTime = System.currentTimeMillis();
			}
		}
		//this.level.updateSpeed(delta);
		if (System.currentTimeMillis() - this.time >= 1000) {
			System.out.println("DELTA: " + delta);
			System.out.println("SPEED: " + Constants.TRANSLATE_SPEED_MOVE);
			this.time = System.currentTimeMillis();
			this.canRestart = true;
		}
		
		if (this.myBird.isGoingUp()) {
			this.myBird.increaseAngle();
		}
		if (this.myBird.goingDown()) {
			this.myBird.updateAngle();
		}
		
		if (Constants.TRANSLATE)
			this.level.updateTranslate();
		if (Constants.BIRD_MOVE)
			this.myBird.move();
		
		if (this.myBird.hasJumped() && !Constants.OVER) {
			if (this.myBird.getJumpPixels() > 0) {
				this.myBird.updateJumpSpeed(delta);
				if (this.myBird.getY() - (Constants.JUMP_DISTANCE / 2) > 0) {
					this.myBird.updateY(-this.myBird.getJumpSpeed(delta));
				}
				this.myBird.updateJumpPixels(-this.myBird.getJumpSpeed(delta));
				if (this.myBird.getJumpPixels() <= 10) {
					this.myBird.setGoingDown();
				}
			}
		}
		if (this.myBird.goingDown()) {
			this.myBird.updateFallTime();
			if (this.myBird.getY() < Constants.FLOOR) {
				this.myBird.updateY((int)this.myBird.getFallAmount(delta));
			}
		}
		
		if (this.canRestart && Constants.OVER && this.restartTime > 0) {
			if (System.currentTimeMillis() - this.restartTime >= 2000) {
				this.restartGame();
			}
		}
		
		this.myBird.updateAngleRotation();
	}
	
	/**
	 * Starts the game
	 */
	
	public void start() {
		this.started = true;
		Constants.TRANSLATE = true;
		Constants.BIRD_MOVE = true;
	}
	
	/**
	 * Returns if the game has started
	 * @return started or not?
	 */
	
	public boolean started() {
		return this.started;
	}
	
	/**
	 * Restarts the game
	 */
	
	private void restartGame() {	
		this.background.generateBackgrounds();
		this.level.generateLevel();
		this.level.resetTranslate();
		this.successes = 0;
		this.canRestart = false;
		Constants.OVER = false;
		this.myBird.reset();
		this.started  = false;
		this.shake = false;
		this.shakeAmount = 0;
		this.restartTime = 0;
		this.background.setShakeScreen(-2);
		this.oldRecord = this.record;
		this.newRecord = false;
		this.myBird.resetAngle();
		
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new FlappyBird());
		app.setDisplayMode(Constants.WIDTH, Constants.HEIGHT, false);
		app.setVSync(true);
		app.setAlwaysRender(true);
		app.setFullscreen(false);
		app.setShowFPS(false);
		app.setMaximumLogicUpdateInterval(60);
		app.setTargetFrameRate(60);
		app.setIcons(new String[]{"Data/icon16.png", "Data/icon24.png", "Data/icon32.png"});
		app.start();
	}	
}
