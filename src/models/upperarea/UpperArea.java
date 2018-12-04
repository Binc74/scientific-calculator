package models.upperarea;

import models.LowerArea;
import models.elements.Element;

public interface UpperArea {
	void append(Element e);
	void setLowerArea(LowerArea lowerArea);
	String toString();
}
