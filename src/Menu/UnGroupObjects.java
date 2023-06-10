package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DrawArea.Draw;
import DrawArea.DrawObject;
import gui.Canvas;
import tools.singleton;

public class UnGroupObjects implements ActionListener{
	private Canvas canvas;
	private ArrayList<DrawObject> objects = new ArrayList<>();
	private ArrayList<Draw> drawingList = new ArrayList<>();
	
	public UnGroupObjects(Canvas canvas) {
		this.canvas = canvas;
		objects = singleton.getObjectList();
		drawingList = singleton.getDrawingList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).isSelected && objects.get(i).getGroupObjetcts() != null) {
				objects.addAll(objects.get(i).getGroupObjetcts());
				drawingList.addAll(objects.get(i).getGroupObjetcts());
				drawingList.remove(objects.get(i));
				objects.remove(objects.get(i));
			}
		}
		canvas.repaint();
	}
}
