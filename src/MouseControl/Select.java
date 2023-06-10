package MouseControl;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import DrawArea.DrawObject;
import tools.singleton;

public class Select extends Mode{
	protected ArrayList<DrawObject> objects;
	private Select selection;
	
	public Select() {
		super();
		objects = singleton.getObjectList();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		selection = model.DecideMode(e.getX(), e.getY());
		selection.setCanvas(canvas);
		selection.performPressed(e);
		canvas.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		selection.performReleased(e);
		selection = null;
		canvas.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
 		selection.performDragged(e);
		canvas.repaint();
	}
	
	public void drawSelect() {}
	public void performPressed(MouseEvent e) {}
	public void performReleased(MouseEvent e) {}
	public void performDragged(MouseEvent e) {}
}
