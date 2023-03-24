package MouseControl;

import java.awt.event.MouseEvent;

import DrawArea.DrawObject;
import gui.Canvas;

public class Move extends Select{
	protected int selectx, selecty, dstx, dsty;
	
	public Move(Canvas canvas) {
		super(canvas);
	}
	
	@Override
	public void performPressed(MouseEvent e) {
		this.selectx = e.getX();
		this.selecty = e.getY();
	}

	@Override
	public void performDragged(MouseEvent e) {
		for (DrawObject object: objects) {
			if (object.isSelected) {
				this.dstx = object.getx() - selectx;
				this.dsty = object.gety() - selecty;
				object.update(dstx + e.getX(), dsty + e.getY());
			}
		}
		this.selectx = e.getX();
		this.selecty = e.getY();
	}
	
	@Override
	public void performReleased(MouseEvent e) {
		clearSelected();
	}
}
