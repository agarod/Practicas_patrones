package es.ull.patrones.GUI;

import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;


/**
 * @author panos
 */
public class BombGame extends BasicGame
{
	
	
	 private int stateID = -1;
	    private TiledMap map = null;
	    
//	private TiledMap map;
	/** the name of the map, read from map properties, specified by TilED */
	private String mapName;
	
	/** how hard are the monsters, read from layer properties, specified by TilED */
	private String monsterDifficulty;
	
	/** we try to read a property from the map which doesn't exist so we expect the default value */
	private String nonExistingMapProperty;
	
	/** we try to read a property from the layer which doesn't exist so we expect the default value */
	private String nonExistingLayerProperty;
	
	/** how long did we wait already until next update */
	private int updateCounter = 0;
	
	/** changing some tile of the map every UPDATE_TIME milliseconds */
	private static int UPDATE_TIME = 1000;
	
	/** we want to store the originalTileID before we set a new one */
	private int originalTileID = 0;
	
//	private Image Lemmi = null;
//	private SpriteSheet tiles = null;
//	private int x,y;
	
	
	private Animation sprite, up, down, left, right;
    private float x = 34f, y = 34f;

    /** The collision map indicating which tiles block movement - generated based on tile properties */
    private boolean[][] blocked;
    private static final int SIZE = 32;
	
	
    public BombGame() throws SlickException
    {
        super("Bomb game");

    }
 
    @Override
    public void init(GameContainer container) throws SlickException
    {
    	 map = new TiledMap("res/Prueba4.tmx", "res");//ERROR
    	 
    	 Image [] movementUp = {new Image("res/mummy_f.png"), new Image("res/mummy_f.png")};
         Image [] movementDown = {new Image("res/mummy_f.png"), new Image("res/mummy_f.png")};
         Image [] movementLeft = {new Image("res/mummy_f.png"), new Image("res/mummy_f.png")};
         Image [] movementRight = {new Image("res/mummy_f.png"), new Image("res/mummy_f.png")};
         int [] duration = {300, 300};     
         
         /*
          * false variable means do not auto update the animation.
          * By setting it to false animation will update only when
          * the user presses a key.
          */
         up = new Animation(movementUp, duration, false);
         down = new Animation(movementDown, duration, false);
         left = new Animation(movementLeft, duration, false);
         right = new Animation(movementRight, duration, false);
 
         // Original orientation of the sprite. It will look right.
         sprite = right;
         // build a collision map based on tile properties in the TileD map
         blocked = new boolean[map.getWidth()][map.getHeight()];
 
        for (int xAxis=0;xAxis<map.getWidth(); xAxis++)
        {
             for (int yAxis=0;yAxis<map.getHeight(); yAxis++)
             {
                 int tileID = map.getTileId(xAxis, yAxis, 0);
                 String value = map.getTileProperty(tileID, "blocked", "false");

                 if ("true".equals(value))
                 {
                     blocked[xAxis][yAxis] = true;
                 }
             }
         }
         //grassMap = new TiledMap("data/grassmap.tmx");
//    	 Lemmi = new Image("res/mummy_f.png");
//    	 tiles = new SpriteSheet(Lemmi,32,32);
//    	 
//    	 x = 2;
//    	 y = 2;
    }
 
    @Override
    public void update(GameContainer container, int delta) throws SlickException
    {
  
    	Input input = container.getInput();

        if (input.isKeyDown(Input.KEY_UP))
        {
            for (int xAxis=0;xAxis<map.getWidth(); xAxis++)
            {
                 for (int yAxis=0;yAxis<map.getHeight(); yAxis++)
                 {
                     int tileID = map.getTileId(xAxis, yAxis, 0);
                     String value = map.getTileProperty(tileID, "blocked", "false");

                     if ("true".equals(value))
                     {
                         blocked[xAxis][yAxis] = true;
                     }
                 }
             }
           sprite = up;
            if (!isBlocked(x, y - delta * 0.1f))
            {
                sprite.update(delta);
                // The lower the delta the slowest the sprite will animate.
                y -= delta * 0.1f;
            }
            

        }
        else if (input.isKeyDown(Input.KEY_DOWN))
        {
            sprite = down;
            if (!isBlocked(x, y + SIZE + delta * 0.1f))
            {
                sprite.update(delta);
                y += delta * 0.1f;
            }
        }
        else if (input.isKeyDown(Input.KEY_LEFT))
        {
            sprite = left;
            if (!isBlocked(x - delta * 0.1f, y))
            {
                sprite.update(delta);
                x -= delta * 0.1f;
            }
        }
        else if (input.isKeyDown(Input.KEY_RIGHT))
        {
            sprite = right;
            if (!isBlocked(x + SIZE + delta * 0.1f, y))
            {
                sprite.update(delta);
                x += delta * 0.1f;
            }
        }

    	
    /*	int objectLayer = map.getLayerIndex("Objects");
    	if( container.getInput().isKeyPressed(Input.KEY_RIGHT)){
    		if (map.getTileId(x+1, y, objectLayer) == 0){
    			x++;
    		}
    	}
    	if( container.getInput().isKeyPressed(Input.KEY_LEFT)){
    		if (map.getTileId(x+1, y, objectLayer) == 0){
    			x--;
    		}
    	}
    	if( container.getInput().isKeyPressed(Input.KEY_UP)){
    		if (map.getTileId(x, y-1, objectLayer) == 0){
    			y--;
    		}
    	}
    	if( container.getInput().isKeyPressed(Input.KEY_RIGHT)){
    		if (map.getTileId(x, y+1, objectLayer) == 0){
    			y++;
    		}
    	}*/
    	
    }
 
    public void render(GameContainer container, Graphics g) throws SlickException
    {
    	map.render(0,0);
    	sprite.draw((int)x, (int)y);
    }
    private boolean isBlocked(float x, float y)
    {
        int xBlock = (int)x / SIZE;
        int yBlock = (int)y / SIZE;
        return blocked[xBlock][yBlock];
    }
    
}



