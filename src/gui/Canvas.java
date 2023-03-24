package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import DrawArea.Draw;
import DrawArea.DrawObject;

public class Canvas extends JPanel{
	private ArrayList<Draw> drawingList = new ArrayList<>();
	private ArrayList<DrawObject> objects = new ArrayList<>();
	
	public Canvas() { 
		setBackground(Color.white);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < drawingList.size(); i++) {
			drawingList.get(i).draw(g);
		}
	}
	
	public void append(Draw draw) {
		drawingList.add(draw);
	}
	
	public void appendObject(DrawObject object) {
		objects.add(object);
	}
	
	public ArrayList<DrawObject> getobjectlist() {
		return objects;
	}
	
	public ArrayList<Draw> getlist() {
		return drawingList;
	}
}
