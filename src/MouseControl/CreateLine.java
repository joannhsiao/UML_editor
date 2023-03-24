package MouseControl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import DrawArea.ConnectPorts;
import DrawArea.DrawAssociationLine;
import DrawArea.DrawCompositionLine;
import DrawArea.DrawGeneralizationLine;
import DrawArea.DrawObject;
import gui.Canvas;

public class CreateLine extends MouseAdapter{
	Canvas canvas;
	private String type;
	ArrayList<DrawObject> objectlist;
	ConnectPorts start, end;
	
	public CreateLine(Canvas canvas, String type) {
		super();
		this.canvas = canvas;
		this.type = type;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int startx = e.getX(), starty = e.getY();
		objectlist = canvas.getobjectlist();
		for (DrawObject object: objectlist) {
			object.updatePorts();
			start = object.findports(startx, starty);
			if (start != null) {
				break;
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		int dstx = e.getX(), dsty = e.getY();
		objectlist = canvas.getobjectlist();
		for (DrawObject object: objectlist) {
			object.updatePorts();
			end = object.findports(dstx, dsty);
			if (end != null && start != null) {
				DecideLine();
				break;
			}
		}
		
	}

	public void DecideLine() {
		if (type == "Association Line") {
			canvas.append(new DrawAssociationLine(start, end));
		}
		else if (type == "Generalization Line") {
			canvas.append(new DrawGeneralizationLine(start, end));
		}
		else {
			canvas.append(new DrawCompositionLine(start, end));
		}		
		canvas.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}
}
