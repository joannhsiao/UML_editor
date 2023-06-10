package MouseControl;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class SingleSelect extends Select{
	protected Point select;
	protected Rectangle rect;
	
	public SingleSelect() {
		super();
	}
	
	@Override
	public void performPressed(MouseEvent e) {
		model.clearSelected();
		select = new Point(e.getX(), e.getY());
		drawSelect();
	}
	
	@Override
	public void drawSelect() {
		for (int i = objects.size()-1; i >= 0; i--) {
			rect = objects.get(i).rectangle;
			if (rect.contains(select.x, select.y)) {
				objects.get(i).updatePorts();
				objects.get(i).setSelect(true);
				break;
			}
			else {
				objects.get(i).setSelect(false);
			}
		}
	}
}
