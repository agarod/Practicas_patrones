package flappy;

import java.util.Random;

import flappy.graphics.Sprite;

public final class Constants {
	
	public static final String SPRITE_BASE = "Data/Sprites/";
	public static final String PILLAR = "pillar.png";
	public static final String END = "end.png";
	public static final String END_BOTTOM = "endBottom.png";	
	public static final String BACKGROUND = "background.png";
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 512;
	
	public static final int LEVEL_AMOUNT = 25;
	public static final int BACKGROUND_WORLD_SIZE = 110;
	public static final int TOTAL_WORLD_PILLARS = 110;
	public static final int START_DISTANCE = 800;
	public static final int BACKGORUND_SPRITE_WIDTH = 288;
	public static final int BACKGROUNDS_PER_TIME = 4;
	
	public static final int TRANSLATE_SPEED = 35;
	public static int TRANSLATE_SPEED_MOVE = 3;
	public static boolean TRANSLATE = true;
	
	public static final int PILLARS_OFFSET = 28;
	
	public static String START_MESSAGE = "Press SPACE to start!";
	
	public static final int FLOOR = 420;
	
	// GAME LOOP
	public static final long OPTIMAL = 60;
	public static boolean OVER = false;
	
	// BIRD
	
	public static final int START_X = 340;
	public static final int START_Y = 250;
	public static final Sprite BIRD = new Sprite("bird.png");
	public static boolean BIRD_MOVE = true;
	public static final int BIRD_ANGLE = 360;
	
	// Bird Physics constants
	
	public static final double MOVEMENT_TIME = 1;
	public static final int JUMP_RATE = 3;
	public static final int JUMP_DISTANCE = 60;
	public static final double FALL_RATE = 0.55;
	
	private static Random rand;
	
	public static int random(int number) {
		if (rand == null) {
			rand = new Random();
		}
		return rand.nextInt(number);
	}
	
}
