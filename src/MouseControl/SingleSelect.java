package MouseControl;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import gui.Canvas;

public class SingleSelect extends Select{
	protected int selectx, selecty;
	protected Rectangle rect;
	
	public SingleSelect(Canvas canvas) {
		super(canvas);
	}
	
	@Override
	public void performPressed(MouseEvent e) {
		clearSelected();
		this.selectx = e.getX();
		this.selecty = e.getY();
		drawSelect();
	}
	
	@Override
	public void drawSelect() {
		for (int i = objects.size()-1; i >= 0; i--) {
			rect = objects.get(i).rectangle;
			if (rect.contains(selectx, selecty)) {
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
