package MouseControl;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import DrawArea.DrawObject;
import gui.Canvas;

public class MultiSelect extends Select {
	protected ArrayList<DrawObject> selectedobjetcs = new ArrayList<>();
	protected Rectangle rect;
	public Rectangle selectRectangle;
	protected int startx, starty, endx, endy;
	protected boolean DrawRect = false;
	
	public MultiSelect(Canvas canvas) {
		super(canvas);
	}
	
	@Override
	public void performPressed(MouseEvent e) {
		clearSelected();
		selectedobjetcs.clear();
		this.startx = e.getX();
		this.starty = e.getY();
		selectRectangle = new Rectangle();
		
	}
	
	@Override
	public void performReleased(MouseEvent e) {
		clearSelected();
		this.endx = e.getX();
		this.endy = e.getY();
		if (!selectedobjetcs.isEmpty()) {
			selectRectangle.setBounds(startx, starty, Math.abs(endx-startx), Math.abs(endy-starty));
		}
		drawSelect();
	}
	
	@Override
	public void performDragged(MouseEvent e) {
		selectRectangle = new Rectangle(startx, starty, Math.abs(e.getX()-startx), Math.abs(e.getY()-starty));
		findobjects(selectRectangle);
	}
	
	@Override
	public void drawSelect() {
		for (DrawObject object: selectedobjetcs) {
			object.updatePorts();
			object.setSelect(true);
		}
	}
	
	public void findobjects(Rectangle rectangle) {
		for (DrawObject object: objects) {
			rect = object.rectangle;
			if (rectangle.intersects(rect)) {
				selectedobjetcs.add(object);
			}
		}
	}
}
