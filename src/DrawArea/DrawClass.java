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
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		g.drawLine(x, y + height/3, x + width, y + height/3);
		g.drawLine(x, y + 2*height/3, x + width, y + 2*height/3);
		FontMetrics fm = g.getFontMetrics();
        double textWidth = fm.getStringBounds(name, g).getWidth();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 16)); 
        g.drawString(name, (int)(x+width/2-textWidth/2), y+height/6);
	}
}
