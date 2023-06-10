package MouseControl;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import DrawArea.ConnectPorts;
import DrawArea.DrawObject;

public class CreateLine extends Mode{
	private String type;
	ArrayList<DrawObject> objectlist;
	ConnectPorts start, end;
	
	public CreateLine(String type) {
		this.type = type;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point point = e.getPoint();
		start = model.findConnectPorts(point);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Point point = e.getPoint();
		end = model.findConnectPorts(point);
		if (end != null && start != null && end != start) {
			model.CreateLine(type, start, end);
			canvas.repaint();
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}
}
