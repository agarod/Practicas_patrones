package patrones.Personajes;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Circle;

import patrones.Escenario.*;
import patrones.Fisica.BasicGameObject;



public class Pajaro2  extends BasicGameObject implements IPajaro{

		private static final float ACCE = 0.9f;
		
		private final float radioImpacto = 13;
		private float rotacion;
		private final float velocidadRotacion = 8.5f;
		
		
		public Pajaro2(String name) {
			super(name, 100, 200, 0);
			this.hitbox = new Circle(posX, posY, radioImpacto);
			rotacion = 0;
		}
	
	public void update(Input in) {
		if (!EscenarioFacil.gameOver && this.posY > 10
				&& in.isKeyDown(Keyboard.KEY_SPACE)) {
			this.speed = -4.0f;
			rotacion = -45;
		}

		posY += speed;
		speed += ACCE;
		hitbox.setLocation(posX, posY);
		hitbox.setCenterX(posX);
		hitbox.setCenterY(posY);
		rotacion += this.velocidadRotacion;

		rebote();
	}

	public void rebote() {

		if (posY > 390 && speed > 1.32) {
			this.speed = -speed*0.6f;
			this.rotacion = -45;
			this.posY = 390;
		} 
		
		else if (posY >= 390 && speed != 0) {
			speed = 0;
			this.rotacion = 0;
			this.posY = 390;
		}

		if (this.rotacion > 90) {
			this.rotacion = 90;
		}
	}

	public float getRotation() {
		return rotacion;
	}

}
