 package DrawArea;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

public class DrawObject extends Draw{
	protected int x, y, width, height;
	protected Polygon ranges[];
	protected ConnectPorts ports[];
	public boolean isSelected = false;
	public Rectangle rectangle = new Rectangle();
	public String name; 
	
	public DrawObject(int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		rectangle.setBounds(x, y, width, height);
		/* initialize connect ports */
		for (int i = 0; i < 4; i++) {
			ports = new ConnectPorts[] {
					new ConnectPorts(x+width/2, y),
					new ConnectPorts(x, y+height/2),
					new ConnectPorts(x+width/2, y+height),
					new ConnectPorts(x+width, y+height/2)
			};
			ranges = new Polygon[] {
					new Polygon(new int[] {x, x+width, x+width/2}, new int[] {y, y, y+height/2}, 3), 
					new Polygon(new int[] {x, x, x+width/2}, new int[] {y, y+height, y+height/2}, 3), 
					new Polygon(new int[] {x, x+width, x+width/2}, new int[] {y+height, y+height, y+height/2}, 3),
					new Polygon(new int[] {x+width, x+width, x+width/2}, new int[] {y+height, y, y+height/2}, 3)
			};
		}
	}
	
	public void changeName(String NewName) {
		this.name = NewName;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		if (this.isSelected) {
			drawPorts(g);
		}
	}
	
	public int getx() {
		return this.x;
	}
	
	public int gety() {
		return this.y;
	}
	
	public int getwidth() {
		return this.width;
	}
	public int getheight() {
		return this.height;
	}
	
	public void update(int x, int y) {
		this.x = x;
		this.y = y;
		rectangle.setBounds(x, y, width, height);
	}
	
	public void updatePorts() {
		ports[0].update(x+width/2, y);
		ports[1].update(x, y+height/2);
		ports[2].update(x+width/2, y+height);
		ports[3].update(x+width, y+height/2);
		
		ranges = new Polygon[] {
				new Polygon(new int[] {x, x+width, x+width/2}, new int[] {y, y, y+height/2}, 3), 
				new Polygon(new int[] {x, x, x+width/2}, new int[] {y, y+height, y+height/2}, 3), 
				new Polygon(new int[] {x, x+width, x+width/2}, new int[] {y+height, y+height, y+height/2}, 3),
				new Polygon(new int[] {x+width, x+width, x+width/2}, new int[] {y+height, y, y+height/2}, 3)
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
}
