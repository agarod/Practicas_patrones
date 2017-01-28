package states;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import varios.CharacterStats;
import varios.Item;
import varios.Level;
import varios.NPCAI;
import varios.NPCInteraction;
import varios.PlayerInteraction;
import varios.World;
import es.ull.patrones.Characters.BadLemming;
import es.ull.patrones.Characters.Friendly;
import es.ull.patrones.Characters.Lemming;



public class GameplayState extends BasicGameState {

    int stateID = 1;
    public String levelID;

    // PERSONAJE Y ENEMIGOS
    Lemming player;

    BadLemming TioMalo,
               Gilgamesh;
    // LEVELS ~~~~~~~~~~~~
    World world;
    TiledMap map1, map2, map3;
    Item[] item1;
    Friendly[] friendly1;
    BadLemming[] enemyset1, enemyset2, enemyset3;  //enemyset# represents the enemies in their corresponding map number
    Level[] levels;
    PlayerInteraction playerInteraction;
    NPCInteraction npcInteraction;
    NPCAI npcAI;

    public GameplayState(int stateID){
        this.stateID = stateID;
    }

    @Override
    public int getID() {
        return 1;
    }
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        //INITIALIZE ALL ENTITIES and levels!
        //set defaults

        // PERSONAJE Y ENEMIGOS
        int [] duration = {300, 300};
            //Jugador
            CharacterStats playerStats = new CharacterStats(1.5f);
            player = new Lemming("data/char2", duration, 100, 100, 7, 10, 18, 22, playerStats);
            //Enemigo
            CharacterStats TioMaloStats = new CharacterStats(0.5f);
            TioMalo = new BadLemming("data/sprites/greendragon", duration, 224, 200, 7, 10, 18, 22, TioMaloStats);
            //Enemigo
            CharacterStats GilgameshStats = new CharacterStats(0.5f);
            Gilgamesh = new BadLemming("data/sprites/blueslime", duration, 300, 300, 7, 10, 18, 22, GilgameshStats);


        // NIVELES
        levels = new Level[3];
        world = new World("1", 50, 100, levels);

            //NIVEL 1
            map1 = new TiledMap("data/room1.tmx");
            item1 = new Item[0];
            friendly1 = new Friendly[0];
            enemyset1 = new BadLemming[0];
            levels[0] = new Level("1", map1, item1, enemyset1, friendly1, player);

            //NIVEL 2
            map2 = new TiledMap("data/map1v2.tmx");
            enemyset2 = new BadLemming[1];
            enemyset2[0] = TioMalo;
            levels[1] = new Level("2", map2, item1, enemyset2, friendly1, player);

          
            //NIVEL 3
            map3 = new TiledMap("data/cave1.tmx");
            enemyset3 = new BadLemming[1];
            enemyset3[0] = Gilgamesh;
            levels[2] = new Level ("3", map3, item1, enemyset3, friendly1, player);


        world.InitializeFirstLevel();
        npcAI = new NPCAI(world.GetCurrentLevel());

    }


    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        Input input = container.getInput();
        npcAI.RunAI(delta);
        world.UpdateWorld(delta, npcAI);

        if(input.isKeyDown(Input.KEY_UP)){
            world.UpdatePlayer(Input.KEY_UP, delta, sbg);
        }
        else if(input.isKeyDown(Input.KEY_DOWN)){
            world.UpdatePlayer(Input.KEY_DOWN, delta, sbg);
        }
        else if(input.isKeyDown(Input.KEY_LEFT)){
            world.UpdatePlayer(Input.KEY_LEFT, delta, sbg);
        }
        else if(input.isKeyDown(Input.KEY_RIGHT)){
            world.UpdatePlayer(Input.KEY_RIGHT, delta, sbg);
        }
        else{
            world.UpdatePlayer(sbg);
        }
        
    }

    public void render(GameContainer container, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        world.RenderCurrentLevel();
        for(BadLemming enemy: world.GetEnemyArray()){
            enemy.GetCharacterRenderableDirection().draw(enemy.GetX(), enemy.GetY());
        }
        player.GetCharacterRenderableDirection().draw(player.GetX(), player.GetY());
 
    }
}
