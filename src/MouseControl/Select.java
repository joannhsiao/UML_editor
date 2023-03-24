package MouseControl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import DrawArea.DrawObject;
import gui.Canvas;

public class Select extends MouseAdapter{
	Canvas canvas;
	protected ArrayList<DrawObject> objects = new ArrayList<>();
	private Select selection;
	
	public Select(Canvas canvas) {
		this.canvas = canvas;
		objects = canvas.getobjectlist();
	}
	
	public Select DecideMode(int selectx, int selecty) {
		boolean OnObject = false;
		for (int i = objects.size()-1; i >= 0; i--) {
			if (objects.get(i).rectangle.contains(selectx, selecty)) {
				if (objects.get(i).isSelected) {
					return new Move(canvas);
				}
				OnObject = true;
				break;
			}
		}
		if (OnObject) {
			return new SingleSelect(canvas);
		}
		else if (!OnObject) {
			return new MultiSelect(canvas);
		}
		else {
			return null;
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		selection = DecideMode(e.getX(), e.getY());
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
	
	public void clearSelected() {
		for (DrawObject object: objects) {
			object.setSelect(false);
		}
	}
	
	public void drawSelect() {}
	public void performPressed(MouseEvent e) {}
	public void performReleased(MouseEvent e) {}
	public void performDragged(MouseEvent e) {}
}
