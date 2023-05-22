package MouseControl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DrawArea.DrawCase;
import DrawArea.DrawClass;
import DrawArea.DrawObject;
import gui.Canvas;

public class CreateObject extends MouseAdapter{
	Canvas canvas;
	private String type;
	
	public CreateObject(Canvas canvas, String type) {
		super();
		this.canvas = canvas;
		this.type = type;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		DrawObject object;
		if (type == "Class") {
			object = new DrawClass(e.getX(), e.getY(), 150, 150);
		}
		else {
			object = new DrawCase(e.getX(), e.getY(), 150, 100);
		}
		canvas.append(object);
		canvas.appendObject(object);
		canvas.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
