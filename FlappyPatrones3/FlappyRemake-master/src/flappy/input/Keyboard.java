package flappy.input;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import flappy.Constants;
import flappy.FlappyBird;

public class Keyboard {
	
	private FlappyBird flappy;
	
	public Keyboard(FlappyBird f) {
		this.flappy = f;
	}

	public void handleInput(GameContainer c) {
		if (Constants.OVER) {
			return;
		}
		Input in = c.getInput();
		if (in.isKeyPressed(Input.KEY_SPACE)) {
			System.out.println("yes");
			if (!this.flappy.started()) {
				this.flappy.start();
			}
			this.flappy.getBird().jump();
		}
	}


}
