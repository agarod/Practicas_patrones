package patrones.Objetos;

import java.util.LinkedList;
import java.util.List;

import patrones.Escenario.*;
import patrones.Fisica.BasicGameObject;

import org.newdawn.slick.geom.*;

public class Obstacle extends BasicGameObject implements IObstracle {
	// Altura de paso
	private int altura;
	public List<Shape> hitboxes = new LinkedList<>();
	public static boolean passed;


	public Obstacle(String name) {
		super(name, 300, EscenarioFacil.r.nextInt(350), EscenarioFacil.SPEED);
		this.altura = EscenarioFacil.r.nextInt(40) + 80;

		if (!EscenarioFacil.obs.isEmpty()) {
			float diff = posY - EscenarioFacil.obs.get(EscenarioFacil.obs.size() - 1).getPosY();
			if (Math.pow(2, diff) > 90000) {
				if (diff >= 0){
					posY = EscenarioFacil.obs.get(EscenarioFacil.obs.size() - 1).getPosY() + 100;

				}
				else
					posY = EscenarioFacil.obs.get(EscenarioFacil.obs.size() - 1).getPosY() - 100;
			}
		}
		if (posY > 390 - altura)
			posY = 390 - altura;

		this.hitboxes.add(new Rectangle(posX, 0, 52, posY));
		this.hitboxes.add(new Rectangle(posX, posY + altura, 52, 400 - posY
				- altura));

		passed = false;
	}

	public void update() {
		if (!EscenarioFacil.gameOver) {
			this.posX -= this.speed;
			this.hitboxes.get(0).setX(this.posX);
			this.hitboxes.get(1).setX(this.posX);
			if (this.posX < -60) {
				List<Obstacle> t = new LinkedList<>();
				for (Obstacle o : EscenarioFacil.obs) {
					if (o != this)
						t.add(o);
				}
				EscenarioFacil.obs = t;
			}
			
			if (this.posX < 40 && !passed) {
				EscenarioFacil.score++;
				passed = true;
			}
		}

	}

	public int getHeight() {
		return altura;
	}

}
