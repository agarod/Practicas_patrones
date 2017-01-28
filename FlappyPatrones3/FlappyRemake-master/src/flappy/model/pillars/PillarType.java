package flappy.model.pillars;

import flappy.Constants;

public enum PillarType {

	TOP(0, 95, Constants.HEIGHT, -290),
	MIDDLE(0, 170, Constants.HEIGHT, -210),
	MIDDLEBOTTOM(0, 185, Constants.HEIGHT, -200),
	BOTTOM(0, 250, Constants.HEIGHT, -110),
	TOPMIDDLE(0, 40, Constants.HEIGHT, -345),
	BOTTOMMIDDLE(0, 200, Constants.HEIGHT, -185);
	
	private int topY, topHeight, bottomY, bottomHeight;
	
	PillarType(int topY, int topHeight, int bottomY, int bottomHeight) {
		this.topY = topY;
		this.topHeight = topHeight;
		this.bottomY = bottomY;
		this.bottomHeight = bottomHeight;
	}
	
	public int getTopY() {
		return this.topY;
	}
	
	public int getBottomY() {
		return this.bottomY;
	}
	
	public int getTopHeight() {
		return this.topHeight;
	}
	
	public int getBottomHeight() {
		return this.bottomHeight;
	}
}
