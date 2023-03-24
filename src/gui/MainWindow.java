package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Menu.ChangeName;
import Menu.GroupObjects;
import Menu.UnGroupObjects;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import MouseControl.CreateLine;
import MouseControl.CreateObject;
import MouseControl.Select;

public class MainWindow {
	Canvas canvas;
	private ArrayList<JButton> buttons;
	
	public static void main(String args[]) {
		new MainWindow();
	}
	
	public MainWindow() {
		init();
	}
	
	public void init() {
		JFrame frame = new JFrame("UML Editor");
		frame.setBounds(0, 0, 1138, 740);
		frame.setBackground(Color.gray);
		
		canvas = new Canvas();
	    frame.add(canvas, BorderLayout.CENTER);
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu file = new JMenu("File");
		menubar.add(file);
		JMenu edit = new JMenu("Edit");
		menubar.add(edit);
		
		JMenuItem Group = new JMenuItem("Group");
		Group.addActionListener(new GroupObjects(canvas));
		edit.add(Group);
		JMenuItem UnGroup = new JMenuItem("UnGroup");
		UnGroup.addActionListener(new UnGroupObjects(canvas));
		edit.add(UnGroup);
		JMenuItem ChangeObjectName = new JMenuItem("Change Object Name");
		ChangeObjectName.addActionListener(new ChangeName(canvas));
		edit.add(ChangeObjectName);

	    buttons = new ArrayList<JButton>();	// used to collect the buttons list
		JPanel panelbar = new JPanel();
		frame.getContentPane().add(panelbar, BorderLayout.WEST);
	    panelbar.setLayout(new GridLayout(6, 1, 40, 40));
		
	    for (int i = 0; i < ButtonBar.values().length; i++) {
	    	JButton button = new JButton(ButtonBar.values()[i].getname(), new ImageIcon(ButtonBar.values()[i].getimg()));
	    	button.setBackground(Color.white);
	    	panelbar.add(button);
	    	buttons.add(button);
	    	button.addActionListener(new ActionListener(){
		    	public void actionPerformed(ActionEvent e){
		    		DrawingMode(((JButton) e.getSource()));
		    	}
	    	});  
	    }

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);   
	}
	
	private void DrawingMode(JButton b) {
		/* remove the previous MouseListeners */
		if (canvas.getMouseListeners().length != 0) {
			canvas.removeMouseListener(canvas.getMouseListeners()[0]);
		}
		if (canvas.getMouseMotionListeners().length != 0) {
			canvas.removeMouseMotionListener(canvas.getMouseMotionListeners()[0]);
		}
		/* button selection */
		for (JButton button: buttons) {
			button.setBackground(Color.white);
		}
		b.setBackground(Color.lightGray);
		
		switch (ButtonBar.values()[buttons.indexOf(b)].getname()) {
		case "Select":
			Select select = new Select(canvas);
			canvas.addMouseListener(select);
			canvas.addMouseMotionListener(select);
			break;
		case "Association Line":
			canvas.addMouseListener(new CreateLine(canvas, "Association Line"));
			break;
		case "Generalization Line":
			canvas.addMouseListener(new CreateLine(canvas, "Generalization Line"));
			break;
		case "Composition Line":
			canvas.addMouseListener(new CreateLine(canvas, "Composition Line"));
			break;
		case "Class": 
			canvas.addMouseListener(new CreateObject(canvas, "Class"));
			break;
		case "Use Case":
			canvas.addMouseListener(new CreateObject(canvas, "Case"));
			break;
		default:
			break;
		}
	}
}
