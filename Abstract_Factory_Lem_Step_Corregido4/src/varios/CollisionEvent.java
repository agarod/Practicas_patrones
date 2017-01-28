package varios;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

import varios.CommonCode.CharacterDirection;
import varios.CommonCode.CollisionType;
import es.ull.patrones.Characters.Character;

/*
 * Gestiono los eventos de colision
 * Busco dentro del TMX la capa de "property" para comprobar sus atributos y si se puede acceder
 * o por el contrario esta bloqueado
 */

public class CollisionEvent {

    CharacterDirection currentDirection;
    Character character;
    NextLevelInformation nextLevelInfo;
    CollisionType collisionType;
    static float doorX, doorY;

    public static CollisionType CheckForCollision(Character character, TiledMap map) {
        Rectangle collisionBox = character.GetCollisionBox();
        float speed = character.GetCharacterStats().GetSpeed();
        CollisionType collisionType = CollisionType.NoCollision;
        switch(character.GetCharacterDirection()){
            case Up:
                for( int i = 0; i < collisionBox.getWidth(); i++ ){
                    if( collisionType == CommonCode.CollisionType.NoCollision){
                        collisionType = CheckDirectionSpecificCollision(collisionBox.getX() + i,
                                collisionBox.getY() - speed,
                                collisionBox.getX() + (collisionBox.getWidth()/2),
                                collisionBox.getY() + (collisionBox.getHeight()/2) - speed,
                                map);
                    }
                }
                break;

            case Down:
                for( int i = 0; i < collisionBox.getWidth(); i++ ){
                    if( collisionType == CollisionType.NoCollision){
                        collisionType = CheckDirectionSpecificCollision(collisionBox.getX() + i,
                                collisionBox.getY() + collisionBox.getHeight() + speed,
                                collisionBox.getX() + (collisionBox.getWidth()/2),
                                collisionBox.getY() + (collisionBox.getHeight()/2) + speed,
                                map);
                    }
                }
                break;

            case Left:
                for( int i = 0; i < collisionBox.getHeight(); i++ ){
                    if( collisionType == CommonCode.CollisionType.NoCollision){
                        collisionType = CheckDirectionSpecificCollision(collisionBox.getX() - speed,
                                collisionBox.getY() + i,
                                collisionBox.getX() + (collisionBox.getWidth()/2) - speed,
                                collisionBox.getY() + (collisionBox.getHeight()/2),
                                map);
                    }
                }
                break;

            case Right:
                for( int i = 0; i < collisionBox.getHeight(); i++ ){
                    if( collisionType == CommonCode.CollisionType.NoCollision){
                        collisionType = CheckDirectionSpecificCollision(collisionBox.getX() + collisionBox.getWidth() + speed,
                                collisionBox.getY() + i,
                                collisionBox.getX() + (collisionBox.getWidth()/2) + speed,
                                collisionBox.getY() + (collisionBox.getHeight()/2),
                                map);
                    }
                }
                break;

            default:
                //do nothing
                break;
        }
        return collisionType;
    }

    public static CommonCode.CollisionType CheckDirectionSpecificCollision( float collisionX, float collisionY, float doorX, float doorY, TiledMap map){
        CommonCode.CollisionType collisionType = CommonCode.CollisionType.NoCollision;
        if ( isBlocked( collisionX, collisionY, map ) && collisionType.equals(CommonCode.CollisionType.NoCollision) ){
            collisionType = CommonCode.CollisionType.Blocked;
        }
        else if ( !isBlocked( collisionX, collisionY, map ) && collisionType.equals(CommonCode.CollisionType.NoCollision) ){
            collisionType = CommonCode.CollisionType.NoCollision;
        }
        if ( isDoor( doorX, doorY, map ) && collisionType.equals(CommonCode.CollisionType.NoCollision) ){
            collisionType = CommonCode.CollisionType.Door;
        }
        return collisionType;
    }

    public static String getProperty(String name, int tileNumX, int tileNumY, TiledMap map){
        return map.getTileProperty(map.getTileId(tileNumX, tileNumY, 0), name, "noproperty");
    }

    private static boolean isBlocked(float x, float y, TiledMap map){
        return getProperty("blocked", (int) x / CommonCode.MAX_SIZE, (int) y / CommonCode.MAX_SIZE, map).equals("true");
    }

    private static boolean isDoor(float x, float y, TiledMap map){
        return getProperty("door", (int) x / CommonCode.MAX_SIZE, (int) y / CommonCode.MAX_SIZE, map).equals("true");
    }

}
