package DrawArea;

import java.awt.Graphics;

public abstract class Draw {
	private int depth;
	
	public Draw() {}
	
	public void draw(Graphics g) {}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return depth;
	}
}
