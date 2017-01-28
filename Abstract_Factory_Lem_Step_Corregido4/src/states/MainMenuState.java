/*This program was created by Marieta Farova, Kelvin Xu and Aron Yoo
 * from December 17th 2012, to January 24th 2013
 * to create an rpg game in java
 */

package states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;

/**
 *
 * @author root
 */
public class MainMenuState extends BasicGameState {

    //sets the stateID of MainMenuState equal to 0.
    int stateID = 0;
    //declaring play and exit images
    Image playGame;
    Image exitGame;

    public MainMenuState(int stateID){
        this.stateID = stateID;
    }

    @Override
    public int getID(){
        return 0;
    }

    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        playGame = new Image("data/playnowimage.gif");
        exitGame = new Image("data/exitimage.png");
    }

    public void render(GameContainer container, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.drawString("Los Lemmings...", 180, 50);
        grphcs.drawString("que no son Lemmings", 130, 70);
        playGame.draw(150, 120);
        exitGame.draw((192), (340));
    }

    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if((posX > 150 && posX < 335) && (posY > 200 && posY < 350)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(1);
            }
        }

        if((posX > 192 && posX < 292) && (posY > 40 && posY < 140)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }

    
}
