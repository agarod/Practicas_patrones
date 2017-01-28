package varios;

import org.newdawn.slick.tiled.TiledMap;

import es.ull.patrones.Characters.BadLemming;
import es.ull.patrones.Characters.Friendly;
import es.ull.patrones.Characters.Lemming;

/*
 * Carga los niveles del juego personajes y enemigos
 */

public class Level {

    String levelID;
    TiledMap map;
    Item[] items;
    BadLemming[] enemies;
    Friendly[] friendlies;
    Lemming player;

    public Level(String levelID, TiledMap map, Item[] items, BadLemming[] enemies, Friendly[] friendlies, Lemming player){
        this.levelID = levelID;
        this.map = map;
        this.items = items;
        this.enemies = enemies;
        this.friendlies = friendlies;
        this.player = player;
    }

    public void Render(){
        map.render(0, 0);
        for(Item i: items){
            i.Render();
        }
        for(BadLemming i: enemies){
            i.Render();
        }
        for(Friendly i: friendlies){
            i.Render();
        }
        player.Render();
    }

    public TiledMap GetTiledMap(){
        return map;
    }

    public Lemming GetPlayer(){
        return player;
    }

    public String GetLevelID(){
        return levelID;
    }
}