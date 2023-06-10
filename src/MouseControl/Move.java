package MouseControl;

import java.awt.Point;
import java.awt.event.MouseEvent;

import DrawArea.DrawObject;

public class Move extends Select{
	protected Point select, destination;
	
	public Move() {
		super();
	}
	
	@Override
	public void performPressed(MouseEvent e) {
		select = new Point(e.getX(), e.getY());
	}

	@Override
	public void performDragged(MouseEvent e) {
		for (DrawObject object: objects) {
			if (object.isSelected) {
				destination = new Point(object.getx() - select.x, object.gety() - select.y);
				object.update(destination.x + e.getX(), destination.y + e.getY());
			}
		}
		select = new Point(e.getX(), e.getY());
	}
	
	@Override
	public void performReleased(MouseEvent e) {
		model.clearSelected();
	}
}
