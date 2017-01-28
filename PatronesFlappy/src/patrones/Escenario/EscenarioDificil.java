package patrones.Escenario;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.lwjgl.Sys;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
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



public class EscenarioDificil extends BasicGame implements IEscenario  {
	
	static Input input;
	public static Random r;
	IPajaro player;
	Pajaro2 jugador;
	public static float SPEED = 3f;
	public static List<ObstacleDificil> obs;
	public static final long INTERVAL =  700;
	public long lastObstacal;
	public static boolean gameOver;
	public static boolean gameOverFinal = false;
	boolean impacted;
	public static List<GroundDificil> grounds;// for moving ground
	public Image ground;
	public Image sprites;
	public SpriteSheet spriteSheet;
	public Image[] birds = new Image[4];
	public Animation bird;
	public static Integer score;
	
	//IPajaro jugador;
	Integer bestscore = 0;
	Integer tryscore = 0;
	Image bg;

	public EscenarioDificil(String title) {
		
		super(title);
		
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		input=new Input(0);
		gameOver=false;
	
		try {
			AppGameContainer app2 = new AppGameContainer(new EscenarioDificil(
					"Flappy Bird"));
			
			app2.setDisplayMode(300, 512, false);
			app2.setShowFPS(true);
			app2.setTargetFrameRate(70);
			app2.setVSync(true);
			app2.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException {

		g.drawImage(bg, 0, 0);

		for (ObstacleDificil o : obs) {
			// superiores
			g.drawImage(sprites, o.getPosX(), 0, o.getPosX() + 52, o.getPosY(),
					582, 644 - o.hitboxes.get(0).getMaxY(), 634, 644);
			
			// inferiores
			g.drawImage(sprites, o.getPosX() + 5, o.getPosY() + o.getHeight(),
					o.getPosX() + 52, 400, 636, 324, 688, 736 - o.getHeight()
							- o.getPosY());

		}

		g.rotate(jugador.getPosX(), jugador.getPosY(), jugador.getRotation());
		g.drawAnimation(bird, jugador.getPosX() - 18, jugador.getPosY() - 12);
		g.rotate(jugador.getPosX(), jugador.getPosY(), -jugador.getRotation());

		for (GroundDificil grd : grounds) {
			g.drawImage(ground, grd.getPosX(), grd.getPosY());
		}
		
		g.setColor(Color.red);
		g.drawString(EscenarioDificil.score.toString(), 270f, 10f);
		if (gameOver) {
			g.setColor(Color.lightGray);
			g.drawString("GAME OVER!!", 100, 200);
			g.destroy();
//			EscenarioDificil.score = 0;
			if ( EscenarioDificil.score != 0){
				tryscore = EscenarioDificil.score;
				if (EscenarioDificil.score > bestscore)
					bestscore = EscenarioDificil.score;
			}
			System.out.println("Mejor puntuacion-->" + bestscore + "......Puntuacion intento-->"+ tryscore);
			EscenarioDificil.score = 0;


		}
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		r = new Random();
		
		jugador = new Pajaro2("player");
		obs = new LinkedList<>();
		lastObstacal = Sys.getTime();
		player = new Pajaro("player");
		//gameOver = false;
		impacted = false;
		bg = new Image("assets/bgNight.png");
		grounds = new LinkedList<GroundDificil>();
		grounds.add(new GroundDificil("ground", 0));
		ground = new Image("assets/ground.png");
		sprites = new Image("assets/sprites.png");
		birds[0] = sprites.getSubImage(690, 482, 34, 24);// m
		birds[1] = sprites.getSubImage(690, 456, 34, 24);// u
		birds[2] = sprites.getSubImage(690, 482, 34, 24);// m
		birds[3] = sprites.getSubImage(690, 508, 34, 24);// d
		bird = new Animation(birds, 50);
		score = new Integer(0);
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {

		boolean var = true;
		if (gameOverFinal == false){
			if (gameOver) {
				gameOver=false;
				arg0.pause();
			}

			jugador.update(input);
			for (ObstacleDificil o : obs) {
				o.update();
			}

			// Generador de obstaculos
			if (Sys.getTime() - lastObstacal > EscenarioDificil.INTERVAL) {
				obs.add(new ObstacleDificil("obstc"));
				lastObstacal = Sys.getTime();
			}
			// Generar suelo nuevo y eliminar el viejo
			if (grounds.size() < 2 && grounds.get(0).getPosX() < 0)
				grounds.add(new GroundDificil("ground", grounds.get(0).getPosX() + 335));
			// actualiza
			for (GroundDificil g : grounds) {
				g.update();
			}

			for (ObstacleDificil o : obs) {
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
