 package DrawArea;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

public class DrawObject extends Draw{
	protected int width, height;
	protected Point point;
	protected Polygon ranges[];
	protected ConnectPorts ports[];
	public boolean isSelected = false;
	public Rectangle rectangle = new Rectangle();
	public String name; 
	
	public DrawObject(int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		point = new Point(x, y);
		rectangle.setBounds(x, y, width, height);
		SetPorts();
	}
	
	@Override
	public void draw(Graphics g) {
		if (this.isSelected) {
			drawPorts(g);
		}
	}
	
	public int getx() {
		return point.x;
	}
	
	public int gety() {
		return point.y;
	}
	
	public void update(int x, int y) {
		point = new Point(x, y);
		rectangle.setBounds(x, y, width, height);
	}
	
	public void SetPorts() {
		/* initialize connect ports */
		for (int i = 0; i < 4; i++) {
			ports = new ConnectPorts[] {
					new ConnectPorts(point.x+width/2, point.y),
					new ConnectPorts(point.x, point.y+height/2),
					new ConnectPorts(point.x+width/2, point.y+height),
					new ConnectPorts(point.x+width, point.y+height/2)
			};
			ranges = new Polygon[] {
					new Polygon(new int[] {point.x, point.x+width, point.x+width/2}, new int[] {point.y, point.y, point.y+height/2}, 3), 
					new Polygon(new int[] {point.x, point.x, point.x+width/2}, new int[] {point.y, point.y+height, point.y+height/2}, 3), 
					new Polygon(new int[] {point.x, point.x+width, point.x+width/2}, new int[] {point.y+height, point.y+height, point.y+height/2}, 3),
					new Polygon(new int[] {point.x+width, point.x+width, point.x+width/2}, new int[] {point.y+height, point.y, point.y+height/2}, 3)
			};
		}
	}
	
	public void updatePorts() {
		ports[0].update(point.x+width/2, point.y);
		ports[1].update(point.x, point.y+height/2);
		ports[2].update(point.x+width/2, point.y+height);
		ports[3].update(point.x+width, point.y+height/2);
		
		ranges = new Polygon[] {
				new Polygon(new int[] {point.x, point.x+width, point.x+width/2}, new int[] {point.y, point.y, point.y+height/2}, 3), 
				new Polygon(new int[] {point.x, point.x, point.x+width/2}, new int[] {point.y, point.y+height, point.y+height/2}, 3), 
				new Polygon(new int[] {point.x, point.x+width, point.x+width/2}, new int[] {point.y+height, point.y+height, point.y+height/2}, 3),
				new Polygon(new int[] {point.x+width, point.x+width, point.x+width/2}, new int[] {point.y+height, point.y, point.y+height/2}, 3)
		};
	}
	
	public ConnectPorts[] getConnectPorts() {
		return ports;
	}
	
	public ConnectPorts findports(int posx, int posy) {
		for (int i = 0; i < ranges.length; i++) {
			if (ranges[i].contains(posx, posy)) {
				return ports[i];
			}
		}
		return null;
	}
	
	public void drawPorts(Graphics g) {
		for (ConnectPorts port: ports) {
			updatePorts();
			port.draw(g);
		}
	}
	
	public void setSelect(boolean select) {
		this.isSelected = select;
	}
	
	public ArrayList<DrawObject> getGroupObjetcts(){ 
		return null; 
	}
	
	public void changeName(String NewName) {
		this.name = NewName;
	}
}
