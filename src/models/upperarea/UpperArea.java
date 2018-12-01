package models.upperarea;

import models.LowerArea;

/**
 * Model for the upper display area of the calculator.
 * 
 * @author Bin Chen
 */
public class UpperArea {
	
	private LowerArea lowerArea;
	
	public UpperArea() {
		
	}
	
	public void setLowerArea(LowerArea lowerArea) {
		this.lowerArea = lowerArea;
	}
}
