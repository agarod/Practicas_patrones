package flappy.model.pillars;

import flappy.Constants;
import flappy.FlappyBird;
import flappy.graphics.Sprite;

public class PillarsFactory {

	private FlappyBird instance;
	
	public PillarsFactory(FlappyBird bird) {
		this.instance = bird;
	}
	
	public Pillars createPillars(int x, PillarType p) {
		Pillar a = new Pillar(x, p.getTopY(), p.getTopHeight(),
				createPillarSprite(), createPillarEnd(false), false);
		Pillar b = new Pillar(x, p.getBottomY(), p.getBottomHeight(),
				createPillarSprite(), createPillarEnd(true), true);
		return new Pillars(a, b, instance);
	}
	
	private Sprite createPillarSprite() {
		return new Sprite(Constants.PILLAR);
	}
	
	private Sprite createPillarEnd(boolean isBottom) {
		return (isBottom) ? new Sprite(Constants.END) : new Sprite(Constants.END_BOTTOM);
	}
}
