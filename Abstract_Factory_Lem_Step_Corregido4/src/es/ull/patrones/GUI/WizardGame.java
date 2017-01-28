package es.ull.patrones.GUI;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


/**
 * @author panos
 */
public class WizardGame extends BasicGame
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
	
    public WizardGame() throws SlickException
    {
        super("Wizard game");

    }
 
//    public static void main(String[] arguments)
//    {
//       
//    }
 
    @Override
    public void init(GameContainer container) throws SlickException
    {
    	 map = new TiledMap("res/prueba.tmx", "res");//ERROR

    	 
    	
    	
    	
    	
    	//map = new TiledMap("res/Escenario1.tmx","res");
//    	map = new TiledMap("res/Tiled","res");
//		// read some properties from map and layer
//		mapName = map.getMapProperty("name", "Unknown map name");
////		monsterDifficulty = map.getLayerProperty(0, "monsters", "easy peasy");
////		nonExistingMapProperty = map.getMapProperty("zaphod", "Undefined map property");
////		nonExistingLayerProperty = map.getLayerProperty(1, "beeblebrox", "Undefined layer property");
//		
//		// store the original tileid of layer 0 at 10, 10
//		originalTileID = map.getTileId(10, 10, 0);
    }
 
    @Override
    public void update(GameContainer container, int delta) throws SlickException
    {
    }
 
    public void render(GameContainer container, Graphics g) throws SlickException
    {
    	map.render(0,0);
    }
}
