package DrawArea;

import java.awt.Graphics;

public class DrawLine extends Draw{
	ConnectPorts start, end;
	protected int startx, starty, dstx, dsty;
	
	public DrawLine(ConnectPorts start, ConnectPorts end) {
		this.start = start;
		this.end = end;
		startx = start.getX();
		starty = start.getY();
		dstx = end.getX();
		dsty = end.getY();
	}
	public void draw(Graphics g) {
		super.draw(g);
		startx = start.getX();
		starty = start.getY();
		dstx = end.getX();
		dsty = end.getY();
	}
}
