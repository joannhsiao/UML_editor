package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import DrawArea.DrawObject;
import gui.Canvas;

public class ChangeName implements ActionListener {
	Canvas canvas;
	public String getnameString = null;
	ArrayList<DrawObject> objects = new ArrayList<>();
	
	public ChangeName(Canvas canvas) {
		this.canvas = canvas;
		objects = canvas.getobjectlist();
	}
	
	public void changename() {
		for (DrawObject object: objects) {
			if (object.isSelected) {
				if (getnameString != null) {
					object.changeName(getnameString);
				}
			}
		}
		canvas.repaint();
	}
	
	public void ShowDialog() {
		getnameString = JOptionPane.showInputDialog("Enter the name: ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ShowDialog();
		changename();
	}
}
