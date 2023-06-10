package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DrawArea.Draw;
import DrawArea.DrawGroup;
import DrawArea.DrawObject;
import gui.Canvas;
import tools.singleton;

public class GroupObjects implements ActionListener{
	private Canvas canvas;
	private ArrayList<DrawObject> objects = new ArrayList<>();
	private ArrayList<Draw> drawingList = new ArrayList<>();
	
	public GroupObjects(Canvas canvas) {
		this.canvas = canvas;
		objects = singleton.getObjectList();
		drawingList = singleton.getDrawingList();
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<DrawObject> grouplist = new ArrayList<>();
		for (DrawObject object: objects) {
			if (object.isSelected) {
				grouplist.add(object);
				object.setSelect(false);
			}
		}
		if (grouplist.size() > 1) {
			DrawGroup group = new DrawGroup(0, 0, -1, -1, grouplist);
			objects.removeAll(grouplist);
			drawingList.removeAll(grouplist);
			objects.add(group);
			drawingList.add(group);
		}
		else if (grouplist.size() == 1) {
			grouplist.get(0).setSelect(true);
		}
		canvas.repaint();
	}
}
