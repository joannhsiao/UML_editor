package tools;

import java.util.ArrayList;
import java.util.Comparator;

import DrawArea.Draw;
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
	// ToDo: move to model
	public static void SortDrawingList() {
		sortingComparator = getComparator();
		drawingList.sort(sortingComparator);
		objectlist.sort(sortingComparator);
	}
}
