package models.upperarea.states;

import models.elements.Element;
import models.upperarea.UpperArea;

public class BasicUpperAreaState extends BaseUpperAreaState {

	public BasicUpperAreaState(UpperArea upperArea) {
		super(upperArea);
	}
	
	@Override
	public void append(Element e) {
		upperArea.exp.add(e);
	}
	
	@Override
	public double calculate() {
		return 0;
	}
}
