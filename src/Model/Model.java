package Model;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Comparator;

import DrawArea.ConnectPorts;
import DrawArea.Draw;
import DrawArea.DrawLine;
import DrawArea.DrawObject;
import MouseControl.Move;
import MouseControl.MultiSelect;
import MouseControl.Select;
import MouseControl.SingleSelect;
import tools.factory;
import tools.singleton;

public class Model {
	private ArrayList<DrawObject> objectlist;
	private ArrayList<Draw> drawingList;
	private Comparator<Draw> sortingComparator;
	
	public Model(){
		objectlist = singleton.getObjectList();
		drawingList = singleton.getDrawingList();
		sortingComparator = singleton.getComparator();
	}
	
	public void CreateObject(String type, Point point) {
		DrawObject object = factory.GetObject(type, point.x, point.y);
		if (object != null) {
			objectlist.add(object);
			drawingList.add(object);
			object.setDepth(singleton.getNowDepth());
			singleton.addDepth();
		}
	}
	
	public void CreateLine(String type, ConnectPorts start, ConnectPorts end) {
		DrawLine line = factory.GetLine(type, start, end);
		if (line != null) {
			drawingList.add(line);
			line.setDepth(singleton.getNowDepth());
			singleton.addDepth();
		}
	}
	
	public void clearSelected() {
		for (DrawObject object: objectlist) {
			object.setSelect(false);
		}
	}
	// ToDo: when to call it
	public void SortDrawingList() {
		drawingList.sort(sortingComparator);
		objectlist.sort(sortingComparator);
	}
	
	public ConnectPorts findConnectPorts(Point point) {
		ConnectPorts port = null;
		for (DrawObject object: objectlist) {
			object.updatePorts();
			port = object.findports(point.x, point.y);
			if (port != null) {
				break;
			}
		}
		return port;
	}
	
	public void setSelectRectangle(Rectangle rec, Point start, Point e) {
		rec.setBounds(start.x<e.x?start.x:e.x, start.y<e.y?start.y:e.y, Math.abs(start.x-e.x), Math.abs(start.y-e.y));
	}
	
	public Select DecideMode(int selectx, int selecty) {
		boolean OnObject = false;
		for (int i = objectlist.size()-1; i >= 0; i--) {
			if (objectlist.get(i).rectangle.contains(selectx, selecty)) {
				if (objectlist.get(i).isSelected) {
					return new Move();
				}
				OnObject = true;
				break;
			}
		}
		if (OnObject) {
			return new SingleSelect();
		}
		else if (!OnObject) {
			return new MultiSelect();
		}
		else {
			return null;
		}
	}
}
