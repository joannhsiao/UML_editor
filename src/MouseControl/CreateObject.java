package MouseControl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DrawArea.DrawCase;
import DrawArea.DrawClass;
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
		if (type == "Class") {
			DrawClass drawClass = new DrawClass(e.getX(), e.getY(), 150, 150);
			canvas.append(drawClass);
			canvas.appendObject(drawClass);
		}
		else {
			DrawCase drawCase = new DrawCase(e.getX(), e.getY(), 150, 100);
			canvas.append(drawCase);
			canvas.appendObject(drawCase);
		}
		canvas.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
