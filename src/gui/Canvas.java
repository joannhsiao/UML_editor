package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import DrawArea.Draw;
import tools.singleton;

public class Canvas extends JPanel{
	private ArrayList<Draw> drawingList;
	
	public Canvas() { 
		setBackground(Color.white);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawingList = singleton.getDrawingList();
		singleton.SortDrawingList();
		for (int i = 0; i < drawingList.size(); i++) {
			drawingList.get(i).draw(g);
		}
	}
}
