package DrawArea;

import java.awt.Graphics;
import java.awt.Point;

public class ConnectPorts {
	private int PortSize = 10;
	private Point connectPoint;

	public ConnectPorts(int x, int y) {
		connectPoint = new Point(x, y);
	}
	
	public void draw(Graphics g) {
		g.fillRect(connectPoint.x-PortSize/2, connectPoint.y-PortSize/2, PortSize, PortSize);
	}
	
	public int getX() {
		return connectPoint.x;
	}
	
	public int getY() {
		return connectPoint.y;
	}
	
	public void update(int x, int y) {
		connectPoint = new Point(x, y);
	}
}
