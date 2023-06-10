package MouseControl;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class CreateObject extends Mode{
	private String type;
	
	public CreateObject(String type) {
		this.type = type;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point point = e.getPoint();
		model.CreateObject(type, point);
		canvas.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
