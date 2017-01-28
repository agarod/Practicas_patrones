package es.ull.patrones.Laberinto;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.state.StateBasedGame;






import states.GameplayState;
import states.MainMenuState;
import es.ull.patrones.Map.Habitacion;
import es.ull.patrones.Map.Pared;
import es.ull.patrones.Map.PuertaBomba;
import es.ull.patrones.Map.PuertaNORMAL;
import es.ull.patrones.TypeHabitacion.HabitacionNormal;

public class JuegoDelLaberinoConPuertasBomba extends StateBasedGame implements FabricaAbstractaLaberintos {
	 private int stateID = 1;
	    private TiledMap map = null;
		private Animation sprite, up, down, left, right;
	    private float x = 34f, y = 34f;

	    /** The collision map indicating which tiles block movement - generated based on tile properties */
	    private boolean[][] blocked;
	    private static final int SIZE = 34;
	    
	    
	    public static final int menu = 0;
	    public static final int play = 1;
	  //  public static final int gameover = 2;
	  //  public static final int gamewin = 3;
	    
	    public JuegoDelLaberinoConPuertasBomba() {
	    	
	    	super ("JUego con bombas");

	        this.addState(new MainMenuState(menu));
	        this.addState(new GameplayState(play));
	  //      this.addState(new GameOverState(gameover));
	   //     this.addState(new GameWinState(gamewin));
	    
	        
	    }
//	    public static void main(String[] args) {
//	       
//			// TODO Auto-generated constructor stub
//		}
	    public void accion(){
	    	 try
		        {
		            AppGameContainer app2 = new AppGameContainer(new JuegoDelLaberinoConPuertasBomba());
		            app2.setForceExit(false);
		            app2.setDisplayMode(500, 500, false);
		            app2.setTargetFrameRate(60);
		            app2.start();
		            app2.setAlwaysRender(true);
		            app2.destroy();
		        }
		        catch (SlickException e)
		        {
		            e.printStackTrace();
		        }
	    }
	    
	    
//	public JuegoDelLaberinoConPuertasBomba(String title) {
//		super(title);
//		// TODO Auto-generated constructor stub
//	}
	    
	@Override
	public PuertaNORMAL fabricarPuerta(Habitacion h1, Habitacion h2) {
		// TODO Auto-generated method stub
		return new PuertaNORMAL(h1, h2);
	}

	@Override
	public PuertaBomba fabricarPuertaBomba(Habitacion h1, Habitacion h2) {
		// TODO Auto-generated method stub
		return new PuertaBomba(h1, h2);
	}

	@Override
	public Habitacion fabricarHabitacion(int n) {
		// TODO Auto-generated method stub
		return new HabitacionNormal(n);
	}

	@Override
	public Pared fabricarPared() {
		// TODO Auto-generated method stub
		return new Pared();
	}


	@Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.getState(menu) .init(container, this);
        this.getState(play) .init(container, this);
   //     this.getState(gameover) .init(container, this);
    //    this.getState(gamewin) .init(container, this);
        this.enterState(menu);
    }

//	@Override
//	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void init(GameContainer arg0) throws SlickException {
//		// TODO Auto-generated method stub
//		map = new TiledMap("res/Prueba3.tmx", "res");//ERROR
//    	 
//    	 Image [] movementUp = {new Image("res/mummy_f.png"), new Image("res/mummy_f.png")};
//         Image [] movementDown = {new Image("res/mummy_f.png"), new Image("res/mummy_f.png")};
//         Image [] movementLeft = {new Image("res/mummy_f.png"), new Image("res/mummy_f.png")};
//         Image [] movementRight = {new Image("res/mummy_f.png"), new Image("res/mummy_f.png")};
//         int [] duration = {300, 300};     
//         
//         /*
//          * false variable means do not auto update the animation.
//          * By setting it to false animation will update only when
//          * the user presses a key.
//          */
//         up = new Animation(movementUp, duration, false);
//         down = new Animation(movementDown, duration, false);
//         left = new Animation(movementLeft, duration, false);
//         right = new Animation(movementRight, duration, false);
// 
//         // Original orientation of the sprite. It will look right.
//         sprite = right;
//         // build a collision map based on tile properties in the TileD map
//         blocked = new boolean[map.getWidth()][map.getHeight()];
// 
//        for (int xAxis=0;xAxis<map.getWidth(); xAxis++)
//        {
//             for (int yAxis=0;yAxis<map.getHeight(); yAxis++)
//             {
//                 int tileID = map.getTileId(xAxis, yAxis, 0);
//                 String value = map.getTileProperty(tileID, "blocked", "false");
//
//                 if ("true".equals(value))
//                 {
//                     blocked[xAxis][yAxis] = true;
//                 }
//             }
//         }
//	}
//
//	@Override
//	public void update(GameContainer arg0, int arg1) throws SlickException {
//		// TODO Auto-generated method stub
//		
//	}

}
