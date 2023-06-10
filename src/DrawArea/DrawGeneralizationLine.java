package DrawArea;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class DrawGeneralizationLine extends DrawLine{
	public DrawGeneralizationLine(ConnectPorts start, ConnectPorts end) {
		super(start, end);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		int d = 15, h = 10;
		int dx = destination.x - begin.x, dy = destination.y - begin.y;
	    double D = Math.sqrt(dx * dx + dy * dy);
	    if(D == 0.0) {
	      D = 1;
	    }
	    double x, xm = D - d, xn = xm, ym = h, yn = -h;
	    double sin = dy / D, cos = dx / D;
	    x = xm * cos - ym * sin + begin.x;
	    ym = xm * sin + ym * cos + begin.y;
	    xm = x;
	    x = xn * cos - yn * sin + begin.x;
	    yn = xn * sin + yn * cos + begin.y;
	    xn = x;
	    
	    ((Graphics2D) g).setStroke(new BasicStroke(1.0f));
	    g.drawLine(begin.x, begin.y, destination.x, destination.y);
	    g.setColor(Color.white);
		Polygon triangle = new Polygon();
		triangle.addPoint(destination.x, destination.y);
		triangle.addPoint((int)xm, (int)ym);
		triangle.addPoint((int)xn, (int)yn);
		g.fillPolygon(triangle);
		g.setColor(Color.black);
		g.drawLine(destination.x, destination.y, (int)xm, (int)ym);
		g.drawLine(destination.x, destination.y, (int)xn, (int)yn);
		g.drawLine((int)xm, (int)ym, (int)xn, (int)yn);
	}
}

