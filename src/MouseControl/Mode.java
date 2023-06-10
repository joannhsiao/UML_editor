package MouseControl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Model;
import gui.Canvas;

public abstract class Mode extends MouseAdapter{
	protected Canvas canvas;
	protected String type;
	protected Model model;
	
	public Mode(){
		model = new Model();
	}
	
	public Mode(String type) {
		this.type = type;
	}
	
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
