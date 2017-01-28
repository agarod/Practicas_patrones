package varios;

import org.newdawn.slick.geom.Rectangle;

import varios.CommonCode.IntersectionType;
import es.ull.patrones.Characters.BadLemming;
import es.ull.patrones.Characters.Friendly;


public class IntersectionEvent {

    public static IntersectionType CheckForIntersection(Level level) {
        Rectangle entityCollisionBox;
        IntersectionType intersectionType;
        Rectangle characterCollisionBox = level.player.GetCollisionBox();
        intersectionType = IntersectionType.NoIntersection;
        
        for ( BadLemming enemy: level.enemies ){
            entityCollisionBox = enemy.GetCollisionBox();
            if( characterCollisionBox.intersects(entityCollisionBox) ){
                intersectionType = IntersectionType.Enemy;
            }
        }
        for ( Friendly friendly: level.friendlies ){
            entityCollisionBox = friendly.GetCollisionBox();
            if( characterCollisionBox.intersects(entityCollisionBox) ){
                intersectionType = IntersectionType.Friendly;
            }
        }
        for ( Item item: level.items ){
            entityCollisionBox = item.GetCollisionBox();
            if( characterCollisionBox.intersects(entityCollisionBox) ){
                intersectionType = IntersectionType.Item;
            }
        }
        return intersectionType;
    }
}
