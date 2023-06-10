package DrawArea;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawCompositionLine extends DrawLine{
	public DrawCompositionLine(ConnectPorts start, ConnectPorts end) {
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
	    x = xm + xn - destination.getX();
	    int y = (int) (ym + yn - destination.y);
	    int[] xpoints = {destination.x, (int)xm, (int)x, (int)xn}, ypoints = {destination.y, (int)ym, y, (int)yn};
	    
	    ((Graphics2D) g).setStroke(new BasicStroke(3.0f));
	    g.drawLine(begin.x,begin.y, destination.x, destination.y);
	    g.setColor(Color.white);
	    g.fillPolygon(xpoints, ypoints, xpoints.length);
	    g.setColor(Color.black);
	    g.drawPolygon(xpoints, ypoints, xpoints.length);
		((Graphics2D) g).setStroke(new BasicStroke(1.0f));
	}
}
