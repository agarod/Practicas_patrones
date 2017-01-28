package varios;

import org.newdawn.slick.Renderable;

import es.ull.patrones.Characters.Entity;

/*
 * Los personajes del juego se tratan como items que dependen de Entity , y se encarga de dibujarlos
 */

public class Item extends Entity {
    
    protected Renderable currentRenderable;

    public Item(float x, float y, float colxOffset, float colyOffset, float colWidth, float colHeight) {
        super(x, y, colxOffset, colyOffset, colWidth, colHeight);
    }

    public void Render() {
        currentRenderable.draw(x, y);
    }
}