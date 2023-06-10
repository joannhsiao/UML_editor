package DrawArea;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

public class DrawCase extends DrawObject{

	public DrawCase(int x, int y, int width, int height) {
		super(x, y, width, height);
		name = "Use Case";
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.white);
		g.fillOval(point.x, point.y, width, height);
		g.setColor(Color.black);
		g.drawOval(point.x, point.y, width, height);
		FontMetrics fm = g.getFontMetrics();
        double textWidth = fm.getStringBounds(name, g).getWidth();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 16)); 
		g.drawString(name, (int)(point.x+width/2-textWidth/2), point.y+height/2);
	}
}
