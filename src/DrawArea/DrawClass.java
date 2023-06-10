package DrawArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class DrawClass extends DrawObject{
	
	public DrawClass(int x, int y, int width, int height) {
		super(x, y, width, height);
		name = "Class"; 
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.white);
		g.fillRect(point.x, point.y, width, height);
		g.setColor(Color.black);
		g.drawRect(point.x, point.y, width, height);
		g.drawLine(point.x, point.y + height/3, point.x + width, point.y + height/3);
		g.drawLine(point.x, point.y + 2*height/3, point.x + width, point.y + 2*height/3);
		FontMetrics fm = g.getFontMetrics();
        double textWidth = fm.getStringBounds(name, g).getWidth();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 16)); 
        g.drawString(name, (int)(point.x+width/2-textWidth/2), point.y+height/6);
	}
}
