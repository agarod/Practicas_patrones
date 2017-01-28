package patrones.Objetos;

import patrones.Fisica.BasicGameObject;
import patrones.Escenario.*;



public class GroundDificil extends BasicGameObject implements IGround{

	public GroundDificil(String name, float start) {
		super(name, start, 400, EscenarioDificil.SPEED);
	}

	public void update() {
		if (!EscenarioDificil.gameOver) {
			posX -= speed;
			if (posX < -340)
				EscenarioDificil.grounds.remove(this);
		}
	}

}
