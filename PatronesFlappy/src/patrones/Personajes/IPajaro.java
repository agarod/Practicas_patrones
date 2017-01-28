package patrones.Personajes;

import org.newdawn.slick.Input;

public interface IPajaro {
	public void update(Input in);
	public void rebote();
	public float getRotation();
}
