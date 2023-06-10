package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DrawArea.DrawObject;
import gui.Canvas;
import tools.singleton;

public class ChangeName implements ActionListener {
	private Canvas canvas;
	private ArrayList<DrawObject> objects = new ArrayList<>();
	public String newNameString = null;
	
	public ChangeName(Canvas canvas) {
		this.canvas = canvas;
		objects = singleton.getObjectList();
	}
	
	public void changename() {
		for (DrawObject object: objects) {
			if (object.isSelected) {
				if (newNameString != null) {
					object.changeName(newNameString);
				}
			}
		}
		canvas.repaint();
	}
	
	public void ShowDialog() {
		newNameString = JOptionPane.showInputDialog("Enter the name: ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ShowDialog();
		changename();
	}
}
