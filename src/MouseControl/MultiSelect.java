package MouseControl;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import DrawArea.DrawObject;

public class MultiSelect extends Select {
	protected ArrayList<DrawObject> selectedobjects = new ArrayList<>();
	public Rectangle selectRectangle;
	protected Point start, end;
	protected boolean DrawRect = false;
	
	public MultiSelect() {
		super();
	}
	
	@Override
	public void performPressed(MouseEvent e) {
		model.clearSelected();
		selectedobjects.clear();
		start = new Point(e.getX(), e.getY());
		selectRectangle = new Rectangle();
	}
	
	@Override
	public void performReleased(MouseEvent e) {
		model.clearSelected();
		end = new Point(e.getX(), e.getY());
		if (!selectedobjects.isEmpty()) {
			model.setSelectRectangle(selectRectangle, start, end);
		}
		drawSelect();
	}
	
	@Override
	public void performDragged(MouseEvent e) {
		model.setSelectRectangle(selectRectangle, start, e.getPoint());
		findobjects(selectRectangle);
	}
	
	@Override
	public void drawSelect() {
		for (DrawObject object: selectedobjects) {
			object.updatePorts();
			object.setSelect(true);
		}
	}
	
	public void findobjects(Rectangle rectangle) {
		for (DrawObject object: objects) {
			if (rectangle.intersects(object.rectangle)) {
				selectedobjects.add(object);
			}
		}
	}
}
