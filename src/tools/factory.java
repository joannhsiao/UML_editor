package tools;

import DrawArea.ConnectPorts;
import DrawArea.DrawAssociationLine;
import DrawArea.DrawCase;
import DrawArea.DrawClass;
import DrawArea.DrawCompositionLine;
import DrawArea.DrawGeneralizationLine;
import DrawArea.DrawLine;
import DrawArea.DrawObject;

public class factory {
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
