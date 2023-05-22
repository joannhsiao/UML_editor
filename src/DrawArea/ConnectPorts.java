package DrawArea;

import java.awt.Graphics;

public class ConnectPorts {
	private int x, y, PortSize = 10;

	public ConnectPorts(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		g.fillRect(x-PortSize/2, y-PortSize/2, PortSize, PortSize);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void update(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
