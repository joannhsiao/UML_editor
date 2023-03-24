package gui;

public enum ButtonBar {
	Select("Select", ".\\img\\Select.png"), 
	Association("Association Line", ".\\img\\Association.png"), 
	Generalization("Generalization Line", ".\\img\\Generalization.png"), 
	Composition("Composition Line", ".\\img\\Composition.png"), 
	Class("Class", ".\\img\\Class.png"), 
	Usecase("Use Case", ".\\img\\UseCase.png");
	
	private String name;
	private String imgpath;

	ButtonBar(String name, String imgpath){
		this.name = name;
		this.imgpath = imgpath;
	}
	public String getname() {
		return name;
	}
	public String getimg() {
		return imgpath;
	}
}
