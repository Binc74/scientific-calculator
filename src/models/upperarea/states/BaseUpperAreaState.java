package models.upperarea.states;

import models.elements.Element;
import models.upperarea.UpperArea;

public abstract class BaseUpperAreaState implements UpperAreaState {
	protected UpperArea upperArea;
	
	public BaseUpperAreaState(UpperArea upperArea) {
		this.upperArea = upperArea;
	}
	
	public abstract void append(Element e);
	public abstract double calculate();
}
