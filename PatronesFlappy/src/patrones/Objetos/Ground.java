package patrones.Objetos;

import patrones.Fisica.BasicGameObject;
import patrones.Escenario.*;

public class Ground extends BasicGameObject implements IGround{

	public Ground(String name, float start) {
		super(name, start, 400, EscenarioFacil.SPEED);
	}

	public void update() {
		if (!EscenarioFacil.gameOver) {
			posX -= speed;
			if (posX < -340)
				EscenarioFacil.grounds.remove(this);
		}
	}

}
