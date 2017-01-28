package varios;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

/*
 * Controla la interaccion del personaje
 * Se podria añadir un sistema de vidas... o que muera simplemente
 */

public class PlayerInteraction {

    boolean cambioNivel = false;
    boolean gameOver = false;
    boolean gameWin = false;
    NextLevelInformation nextLevelInfo;
    Level nivel;
   

    public PlayerInteraction(Level NivelActual){
        this.nivel = NivelActual;
    }

    public void HandleEvents(int key, long delta){

        //Cambia la direccion del jugador segun la tecla presionada
        switch(key){
            case Input.KEY_UP:
                nivel.player.ChangeRenderCharacterDirection(CommonCode.CharacterDirection.Up);
                nivel.player.update(delta);
                break;

            case Input.KEY_DOWN:
                nivel.player.ChangeRenderCharacterDirection(CommonCode.CharacterDirection.Down);
                nivel.player.update(delta);
                break;

            case Input.KEY_LEFT:
                nivel.player.ChangeRenderCharacterDirection(CommonCode.CharacterDirection.Left);
                nivel.player.update(delta);
                break;

            case Input.KEY_RIGHT:
                nivel.player.ChangeRenderCharacterDirection(CommonCode.CharacterDirection.Right);
                nivel.player.update(delta);
                break;
        }

        //Comprueba si hay colisiones con puertas, muros, enemigos o items que hagan ganar
        switch( CollisionEvent.CheckForCollision(nivel.GetPlayer(), nivel.GetTiledMap()) ){
            case NoCollision:
                if(nivel.player.GetCharacterDirection().equals(CommonCode.CharacterDirection.Up)){
                    nivel.player.MoveUp();
                }
                else if(nivel.player.GetCharacterDirection().equals(CommonCode.CharacterDirection.Down)) {
                    nivel.player.MoveDown();
                }
                else if(nivel.player.GetCharacterDirection().equals(CommonCode.CharacterDirection.Left)) {
                    nivel.player.MoveLeft();
                }
                else if(nivel.player.GetCharacterDirection().equals(CommonCode.CharacterDirection.Right)) {
                    nivel.player.MoveRight();
                }
                break;

            case Blocked:
                break;

            case Door:
                float playerX = nivel.player.GetCollisionBox().getX();
                float playerY = nivel.player.GetCollisionBox().getY();
                Rectangle collisionBox = nivel.player.GetCollisionBox();
                float playerSpeed = nivel.player.GetCharacterStats().GetSpeed();
                float doorX = -1, doorY = -1, startX, startY;
                String levelID;
                if(nivel.player.GetCharacterDirection().equals(CommonCode.CharacterDirection.Up)){
                    doorX = playerX + (collisionBox.getWidth()/2);
                    doorY = playerY + (collisionBox.getHeight()/2) - playerSpeed;
                }
                else if(nivel.player.GetCharacterDirection().equals(CommonCode.CharacterDirection.Down)){
                    doorX = playerX + (collisionBox.getWidth()/2);
                    doorY = playerY + (collisionBox.getHeight()/2) + playerSpeed;
                }
                else if(nivel.player.GetCharacterDirection().equals(CommonCode.CharacterDirection.Left)){
                    doorX = playerX + (collisionBox.getWidth()/2) - playerSpeed;
                    doorY = playerY + (collisionBox.getHeight()/2);
                }
                else if(nivel.player.GetCharacterDirection().equals(CommonCode.CharacterDirection.Right)){
                    doorX = playerX + (collisionBox.getWidth()/2) + playerSpeed;
                    doorY = playerY + (collisionBox.getHeight()/2);
                }
                levelID = CollisionEvent.getProperty("levelID", (int)(doorX / CommonCode.MAX_SIZE), (int)(doorY / CommonCode.MAX_SIZE), nivel.GetTiledMap());
                startX = Float.parseFloat( CollisionEvent.getProperty("startX", (int)(doorX / CommonCode.MAX_SIZE), (int)(doorY / CommonCode.MAX_SIZE), nivel.GetTiledMap() ) );
                startY = Float.parseFloat( CollisionEvent.getProperty("startY", (int)(doorX / CommonCode.MAX_SIZE), (int)(doorY / CommonCode.MAX_SIZE), nivel.GetTiledMap() ) );
                cambioNivel = true;
                nextLevelInfo = new NextLevelInformation(levelID, startX, startY);
                break;
        }

        CheckPlayerIntersections();
        
        if ( nivel.GetLevelID().equals("7") && 
             nivel.player.GetX() >= 192 && nivel.player.GetX() <= 288 &&
             nivel.player.GetY() >= 347 && nivel.player.GetY() <= 416 ){
            gameWin = true;
        }
    }

    public void HandleEvents(){
        CheckPlayerIntersections();
        if ( nivel.GetLevelID().equals("7") &&
             nivel.player.GetX() >= 192 && nivel.player.GetX() <= 288 &&
             nivel.player.GetY() >= 347 && nivel.player.GetY() <= 416 ){
            gameWin = true;
        }
    }

    public void CheckPlayerIntersections(){
        //Check for intersections
        switch( IntersectionEvent.CheckForIntersection(nivel) ){
            case NoIntersection:
                break;

            case Enemy:


            case Friendly:
                break;

            case Item:
                break;
        }
    }

    public NextLevelInformation GetNextLevelInfo(){
        return nextLevelInfo;
    }

    public boolean GetSwitchLevel(){
        return cambioNivel;
    }

    public boolean GetGameOver(){
        return gameOver;
    }

    public boolean GetGameWin(){
        return gameWin;
    }


}