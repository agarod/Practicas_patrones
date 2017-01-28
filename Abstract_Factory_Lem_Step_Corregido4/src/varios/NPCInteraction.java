package varios;

import es.ull.patrones.Characters.BadLemming;
import varios.CommonCode;
import varios.CommonCode.CharacterDirection;

/*
 */
public class NPCInteraction {

    Level level;
    CharacterDirection direction;
    NPCAI npcAI;

    public NPCInteraction(Level level, NPCAI npcAI){
        this.level = level;
    }

    public void HandleEvents(long delta){
        boolean collision;
        for (BadLemming enemigo: level.enemies){
            CharacterDirection horizontalDirection;
            CharacterDirection verticalDirection;
            if (level.player.GetY() < enemigo.GetY()){
                 enemigo.ChangeRenderCharacterDirection(CharacterDirection.Up);
                    collision = CheckNPCCollision(enemigo);
                    if ( !collision ){
                        enemigo.MoveUp();
                    }
                    enemigo.update(delta);
            }
            else {
                 enemigo.ChangeRenderCharacterDirection(CharacterDirection.Down);
                    collision = CheckNPCCollision(enemigo);
                    if ( !collision ){
                        enemigo.MoveDown();
                    }
                    enemigo.update(delta);
            }

            if (level.player.GetX() < enemigo.GetX()){
                enemigo.ChangeRenderCharacterDirection(CharacterDirection.Left);
                    collision = CheckNPCCollision(enemigo);
                    if ( !collision ){
                        enemigo.MoveLeft();
                    }
                    enemigo.update(delta);
            }
            else {
                enemigo.ChangeRenderCharacterDirection(CharacterDirection.Right);
                    collision = CheckNPCCollision(enemigo);
                    if ( !collision ){
                        enemigo.MoveRight();
                    }
                    enemigo.update(delta);
            }
        }

    }

    private boolean CheckNPCCollision(BadLemming character){
        boolean collision;
        switch( CollisionEvent.CheckForCollision( character, level.GetTiledMap() ) ){
            case NoCollision:
                collision = false;
                return collision;

            case Blocked:
                collision = true;
                return collision;

            case Door:
                collision = true;
                return collision;
        }
        collision = true;
        return collision;
    }

}
