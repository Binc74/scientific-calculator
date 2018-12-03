package models.upperarea.states;

import models.elements.Element;

public interface UpperAreaState {
	void append(Element e);
	double calculate();
}
