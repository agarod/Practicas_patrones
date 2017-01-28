package varios;

import varios.CommonCode.CharacterDirection;
import es.ull.patrones.Characters.BadLemming;

/*
 * La inteligencia Artificial de los personajes no controlados
 * basicamente es lo correspondiente a comportamiento CatchBehaviour atribuido a los malos...
 */

public class NPCAI {
    Level level;

    public NPCAI(Level level2){
        this.level = level2;
        
    }

    public void RunAI(long delta){
        for (BadLemming enemigo: level.enemies){
            CharacterDirection horizontalDirection;
            CharacterDirection verticalDirection;
            if (level.player.GetY() < enemigo.GetY()){
                 verticalDirection = CharacterDirection.Up;
            }
            else {
                 verticalDirection = CommonCode.CharacterDirection.Down;
            }
            enemigo.ChangeRenderCharacterDirection(verticalDirection);
            
            if (level.player.GetX() < enemigo.GetX()){
                horizontalDirection = CharacterDirection.Left;
            }
            else {
                horizontalDirection = CharacterDirection.Right;
            }
            enemigo.ChangeRenderCharacterDirection(horizontalDirection);
        }
    }
}