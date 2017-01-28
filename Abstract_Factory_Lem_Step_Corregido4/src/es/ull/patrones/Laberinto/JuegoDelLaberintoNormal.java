package es.ull.patrones.Laberinto;


import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;


import states.GameplayState2;
import states.MainMenuState2;
import es.ull.patrones.Map.Habitacion;
import es.ull.patrones.Map.Pared;
import es.ull.patrones.Map.Puerta;
import es.ull.patrones.Map.PuertaBomba;
import es.ull.patrones.Map.PuertaNORMAL;
import es.ull.patrones.TypeHabitacion.HabitacionNormal;

public class JuegoDelLaberintoNormal extends StateBasedGame implements FabricaAbstractaLaberintos {
	private int stateID = 1;
    private TiledMap map = null;
	private Animation sprite, up, down, left, right;
    private float x = 34f, y = 34f;

    /** The collision map indicating which tiles block movement - generated based on tile properties */
    private boolean[][] blocked;
    private static final int SIZE = 34;
    
    
    public static final int menu = 0;
    public static final int play = 1;
    public static final int gameover = 2;
    public static final int gamewin = 3;
    
    
	public JuegoDelLaberintoNormal(){
		super ("JUego con bombas");

        this.addState(new MainMenuState2(menu));
        this.addState(new GameplayState2(play));
	}

	@Override
	public PuertaNORMAL fabricarPuerta(Habitacion h1, Habitacion h2) {
		// TODO Auto-generated method stub
		return new PuertaNORMAL(h1, h2);
	}

	@Override
	public PuertaBomba fabricarPuertaBomba(Habitacion h1, Habitacion h2) {
		// TODO Auto-generated method stub
		return new PuertaBomba(h1,h2);
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
	public void accion() {
   	 try
     {
         AppGameContainer app = new AppGameContainer(new JuegoDelLaberintoNormal());
         app.setForceExit(false);
         app.setDisplayMode(500, 500, false);
         app.setTargetFrameRate(60);
         app.start();
         app.setAlwaysRender(true);
         app.exit();
     }
     catch (SlickException e)
     {
         e.printStackTrace();
     }
	}
	@Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.getState(menu) .init(container, this);
        this.getState(play) .init(container, this);
        this.enterState(menu);
    }

}
