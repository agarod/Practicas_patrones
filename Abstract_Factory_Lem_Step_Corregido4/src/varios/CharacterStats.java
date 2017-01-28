package varios;

/*
 * Caracteristica de los personajes tales como velocidad y tambien podia servir para poner un sistema de vida
 */
public class CharacterStats {

    float speed;

    public CharacterStats(float speed){
        this.speed = speed;

    }

    public float GetSpeed(){
        return speed;
    }

    public void SetSpeed(float speed){
        this.speed = speed;
    }

    public CharacterStats Clone(){
        return new CharacterStats(speed);
    }
}

