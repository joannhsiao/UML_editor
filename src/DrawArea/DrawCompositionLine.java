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
	    int dx = dstx - startx, dy = dsty - starty;
	    double D = Math.sqrt(dx * dx + dy * dy);
	    if(D == 0.0) {
	      D = 1;
	    }
	    double x, xm = D - d, xn = xm, ym = h, yn = -h;
	    double sin = dy / D, cos = dx / D;
	    x = xm * cos - ym * sin + startx;
	    ym = xm * sin + ym * cos + starty;
	    xm = x;
	    x = xn * cos - yn * sin + startx;
	    yn = xn * sin + yn * cos + starty;
	    xn = x;
	    x = xm + xn - dstx;
	    int y = (int) (ym + yn - dsty);
	    int[] xpoints = {dstx, (int)xm, (int)x, (int)xn}, ypoints = {dsty, (int)ym, y, (int)yn};
	    
	    ((Graphics2D) g).setStroke(new BasicStroke(3.0f));
	    g.drawLine(startx, starty, dstx, dsty);
	    g.setColor(Color.white);
	    g.fillPolygon(xpoints, ypoints, xpoints.length);
	    g.setColor(Color.black);
	    g.drawPolygon(xpoints, ypoints, xpoints.length);
		((Graphics2D) g).setStroke(new BasicStroke(1.0f));
	}
}
