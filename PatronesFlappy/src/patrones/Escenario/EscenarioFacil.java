package patrones.Escenario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.lwjgl.Sys;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.AppletGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import patrones.Personajes.*;
import patrones.Objetos.*;
import patrones.Fisica.*;
import patrones.Personajes.*;
import patrones.Principal.*;



public class EscenarioFacil extends BasicGame implements IEscenario  {
	
	static Input input;
	
	public static Random r;
	IPajaro player ;
	Pajaro jugador;

	public static float SPEED = 3f;
	public static List<Obstacle> obs;
	public static final long INTERVAL = 1700;
	public long lastObstacal;
	public static boolean gameOver;
	public static boolean gameOverFinal = false;
	boolean impacted;
	public static List<Ground> grounds;// for moving ground
	public Image ground;
	public Image sprites;
	public SpriteSheet spriteSheet;
	public Image[] birds = new Image[4];
	public Animation bird;
	public static Integer score;
	
	Integer bestscore = 0;
	Integer tryscore = 0;
	//ArrayList<Integer> bestscore = new ArrayList();

	Image bg;

	public EscenarioFacil(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		input=new Input(0);
		gameOver=false;
	
		AppGameContainer app;
		try {
			
			 app = new AppGameContainer(new EscenarioFacil(
					"Flappy Bird"));
			
			app.setDisplayMode(288, 512, false);
			app.setShowFPS(true);
			app.setTargetFrameRate(70);
			app.setVSync(true);
			app.setForceExit(false);
			app.setShowFPS(false);
			app.start();
			app.destroy();
		//	FlappyPrincipal.reset();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(bg, 0, 0);
		
		for (Obstacle o : obs) {
			// Obstaculos superiores
			g.drawImage(sprites, o.getPosX(), 0, o.getPosX() + 52, o.getPosY(),
					582, 644 - o.hitboxes.get(0).getMaxY(), 634, 644);
			Integer i = new Integer(o.getHeight());

			//Obstaculos inferiores
			g.drawImage(sprites, o.getPosX() + 5, o.getPosY() + o.getHeight(),
					o.getPosX() + 52, 400, 636, 324, 688, 736 - o.getHeight()
							- o.getPosY());

		}
		
		g.rotate(jugador.getPosX(), jugador.getPosY(), jugador.getRotation());
		g.drawAnimation(bird, jugador.getPosX() - 18, jugador.getPosY() - 12);
		g.rotate(jugador.getPosX(), jugador.getPosY(), -jugador.getRotation());
		
		for (Ground grd : grounds) {
			g.drawImage(ground, grd.getPosX(), grd.getPosY());
		}
		g.setColor(Color.red);
		g.drawString(EscenarioFacil.score.toString(), 270f, 10f);
		g.drawString("Mejor Puntuacion:", 10f, 10f);
		g.drawString (bestscore.toString(),20f,20f );
		
		if (gameOver) {
			g.setColor(Color.lightGray);
			g.drawString("GAME OVER!!", 100, 200);
			g.destroy();
			
			if ( EscenarioFacil.score != 0){
				tryscore = EscenarioFacil.score;
				if (EscenarioFacil.score > bestscore)
					bestscore = EscenarioFacil.score;
			}
			
			System.out.println("Mejor puntuacion-->" + bestscore + "......Puntuacion intento-->"+ tryscore);
			EscenarioFacil.score = 0;
			
		}
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		r = new Random();
		jugador = new Pajaro("player");
		player = new Pajaro("player");
		obs = new LinkedList<>();
		lastObstacal = Sys.getTime();
		//gameOver = false;
		impacted = false;
		bg = new Image("assets/background.png");
		grounds = new LinkedList<Ground>();
		grounds.add(new Ground("ground", 0));
		ground = new Image("assets/ground.png");
		sprites = new Image("assets/sprites.png");
		birds[0] = sprites.getSubImage(690, 560, 34, 24);// m
		birds[1] = sprites.getSubImage(690, 534, 34, 24);// u
		birds[2] = sprites.getSubImage(690, 560, 34, 24);// m
		birds[3] = sprites.getSubImage(690, 586, 34, 24);// d
		bird = new Animation(birds, 50);
		score = new Integer(0);
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		boolean var = true;
		if (gameOverFinal == false){
			if (gameOver) {
				gameOver=false;
				arg0.pause();
			}

			jugador.update(input);
			for (Obstacle o : obs) {
				o.update();
			}


			if (Sys.getTime() - lastObstacal > EscenarioFacil.INTERVAL) {
				obs.add(new Obstacle("obstc"));
				lastObstacal = Sys.getTime();
			}

			if (grounds.size() < 2 && grounds.get(0).getPosX() < 0)
				grounds.add(new Ground("ground", grounds.get(0).getPosX() + 335));

			for (Ground g : grounds) {
				g.update();
			}

			for (Obstacle o : obs) {
				
				if (o.hitboxes.get(0).intersects(jugador.getHitbox())
						|| o.hitboxes.get(1).intersects(jugador.getHitbox())){
					gameOver = true;
					//gameOverFinal= true;
					jugador.init(arg0);

				}

			}
			
		}
		else{
				
		}
		
	}

	

}
