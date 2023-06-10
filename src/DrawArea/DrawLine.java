package DrawArea;

import java.awt.Graphics;
import java.awt.Point;

public class DrawLine extends Draw{
	protected ConnectPorts start, end;
	protected Point begin, destination;
	
	public DrawLine(ConnectPorts start, ConnectPorts end) {
		this.start = start;
		this.end = end;
		begin = new Point(start.getX(), start.getY());
		destination = new Point(end.getX(), end.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		begin = new Point(start.getX(), start.getY());
		destination = new Point(end.getX(), end.getY());
		g.drawLine(begin.x, begin.y, destination.x, destination.y);
	}
}
