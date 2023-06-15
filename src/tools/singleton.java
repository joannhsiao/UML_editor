package tools;

import java.util.ArrayList;
import java.util.Comparator;

import DrawArea.ConnectPorts;
import DrawArea.Draw;
import DrawArea.DrawAssociationLine;
import DrawArea.DrawCase;
import DrawArea.DrawClass;
import DrawArea.DrawCompositionLine;
import DrawArea.DrawGeneralizationLine;
import DrawArea.DrawLine;
import DrawArea.DrawObject;

public class singleton {
	private static ArrayList<DrawObject> objectlist;
	private static ArrayList<Draw> drawingList;
	private static Comparator<Draw> sortingComparator;
	private static int NowDepth = 0;
	
	private singleton() {}
	
	public static ArrayList<DrawObject> getObjectList() {
		if (objectlist == null) {
			objectlist = new ArrayList<DrawObject>();
		}
	    return objectlist;
	}
	
	public static ArrayList<Draw> getDrawingList(){
		if (drawingList == null) {
			drawingList = new ArrayList<Draw>();
		}
		return drawingList;
	}
	
	public static int getNowDepth() {
		return NowDepth;
	}
	
	public static void addDepth() {
		NowDepth++;
	}
	
	public static Comparator<Draw> getComparator(){
		if (sortingComparator == null) {
			sortingComparator = new Comparator<Draw>() {
				@Override
				public int compare(Draw d1, Draw d2) {
					if (d1.getDepth() < d2.getDepth()) {
						return -1;
					}
					else if (d1.getDepth() > d2.getDepth()) {
						return 1;
					}
					else {
						return 0;
					}
				}
			};
		}
		return sortingComparator;
	}
	
	public static void SortDrawingList() {
		sortingComparator = getComparator();
		drawingList.sort(sortingComparator);
		objectlist.sort(sortingComparator);
	}
	
	public static DrawObject GetObject(String type, int x, int y) {
		DrawObject object = null;
		if (type == "Class") {
			object = new DrawClass(x, y, 150, 150);
		}
		else {
			object = new DrawCase(x, y, 150, 100);
		}
		return object;
	}
	
	public static DrawLine GetLine(String type, ConnectPorts start, ConnectPorts end) {
		DrawLine line = null;
		if (type == "Association Line") {
			line = new DrawAssociationLine(start, end);
		}
		else if (type == "Generalization Line") {
			line = new DrawGeneralizationLine(start, end);
		}
		else {
			line = new DrawCompositionLine(start, end);
		}
		return line;
	}
}
