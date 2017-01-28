package varios;


/*
 * Declaracion de los enumerados que se haran uso en las diferentes clases
 */
public class CommonCode {

    public static final int MAX_SIZE = 32;

    public enum CharacterDirection {

        Up, Down, Left, Right;
    }

    public enum CollisionType {

        Blocked, Door, NoCollision;
    }

    public enum IntersectionType {

        Player, Enemy, Friendly, Item, NoIntersection;
    }
}

