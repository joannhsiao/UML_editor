package DrawArea;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class DrawGroup extends DrawObject{
	ArrayList<DrawObject> groupObjects;
	
	public DrawGroup(int x, int y, int width, int height, ArrayList<DrawObject> grouplist) {
		super(x, y, width, height);
		this.groupObjects = grouplist;
		SetGroup();
	}
	
	public void SetGroup() {
		for (DrawObject object: groupObjects) {
			Rectangle rect = object.rectangle;
			rectangle = rectangle.union(rect);
		}
		this.width = rectangle.width;
		this.height = rectangle.height;
		point = new Point(rectangle.x, rectangle.y);
		updatePorts();
	}
	
	@Override
	public void update(int x, int y) {
		// TODO Auto-generated method stub
		int dstx = x - point.x;
		int dsty = y - point.y;
		super.update(x, y);
		for(DrawObject object: groupObjects) {
			object.update(dstx+object.point.x, dsty+object.point.y);
			object.updatePorts();
		}
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		for (int i = 0; i < groupObjects.size(); i++) {
			groupObjects.get(i).draw(g);
		}
		if (isSelected) {
		    g.drawRect(point.x, point.y, width, height);
		}
	}
	
	@Override
	public ArrayList<DrawObject> getGroupObjetcts() {
		return groupObjects;
	}
}
