package patrones.Objetos;

import java.util.LinkedList;
import java.util.List;

import patrones.Escenario.EscenarioDificil;
import patrones.Fisica.BasicGameObject;

import org.newdawn.slick.geom.*;


public class ObstacleDificil extends BasicGameObject implements IObstracle {
	// height of passage
	private int height;
	// 2 hitboxes
	public List<Shape> hitboxes = new LinkedList<>();
	public static boolean passed;

	// random number generator

	public ObstacleDificil(String name) {
		super(name, 300, EscenarioDificil.r.nextInt(350), EscenarioDificil.SPEED);
		this.height = EscenarioDificil.r.nextInt(40) + 80;

		if (!EscenarioDificil.obs.isEmpty()) {
			float diff = posY
					- EscenarioDificil.obs.get(EscenarioDificil.obs.size() - 1).getPosY();
			if (Math.pow(2, diff) > 90000) {
				if (diff >= 0)
					posY = EscenarioDificil.obs.get(EscenarioDificil.obs.size() - 1).getPosY() + 100;
				else
					posY = EscenarioDificil.obs.get(EscenarioDificil.obs.size() - 1).getPosY() - 100;
			}
		}
		if (posY > 390 - height)
			posY = 390 - height;

		this.hitboxes.add(new Rectangle(posX, 0, 52, posY));
		this.hitboxes.add(new Rectangle(posX, posY + height, 52, 400 - posY
				- height));

		passed = false;
	}

	public void update() {
		if (!EscenarioDificil.gameOver) {
			this.posX -= this.speed;
			this.hitboxes.get(0).setX(this.posX);
			this.hitboxes.get(1).setX(this.posX);
			if (this.posX < -60) {
				List<ObstacleDificil> t = new LinkedList<>();
				for (ObstacleDificil o : EscenarioDificil.obs) {
					if (o != this)
						t.add(o);
				}
				EscenarioDificil.obs = t;
			}
			if (this.posX < 40 && !passed) {
				EscenarioDificil .score++;
				passed = true;
			}
		}

	}

	public int getHeight() {
		return height;
	}

}
