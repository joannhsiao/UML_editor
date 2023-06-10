package gui;

import MouseControl.Select;
import MouseControl.CreateLine;
import MouseControl.CreateObject;
import MouseControl.Mode;

public enum ButtonBar {
	Select(new Select(), ".\\img\\Select.png"), 
	Association(new CreateLine("Association Line"), ".\\img\\Association.png"), 
	Generalization(new CreateLine("Generalization Line"), ".\\img\\Generalization.png"), 
	Composition(new CreateLine("Composition Line"), ".\\img\\Composition.png"), 
	Class(new CreateObject("Class"), ".\\img\\Class.png"), 
	Usecase(new CreateObject("Use Case"), ".\\img\\UseCase.png");
	
	private Mode mode;
	private String imgpath;

	ButtonBar(Mode mode, String imgpath){
		this.mode = mode;
		this.imgpath = imgpath;
	}
	
	public Mode getMode() {
		return mode;
	}

	public String getImg() {
		return imgpath;
	}
}
