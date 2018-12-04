package models;

import models.elements.Element;
import models.elements.ElementType;
import models.upperarea.UpperArea;

/**
 * Model for the lower display area of the calculator.
 * 
 * @author Bin Chen
 */
public class LowerArea {	
	private StringBuilder rep;		// The string representation of the number
	private boolean hasPeriod;		// True if this number has period
	private boolean isResult;		// True if this number is set by previous result
	private boolean isFinalResult;	// True if this number is the final result
	private boolean isNegative;		// True if this number is negative
	
	private UpperArea upperArea;
	
	public LowerArea() {
		rep = new StringBuilder();
		hasPeriod = false;
		isResult = false;
		isFinalResult = false;
		isNegative = false;
	}
	
	/**
	 * A getter method.
	 */
	public boolean isResult() {
		return isResult || isFinalResult;
	}
	
	/**
	 * A setter for upper area.
	 * 
	 * @param upperArea			the upper area
	 */
	public void setUpperArea(UpperArea upperArea) {
		this.upperArea = upperArea;
	}
	
	private void reset() {
		rep = new StringBuilder();
		hasPeriod = false;
		isNegative = false;	
	}
	
	/**
	 * Append a digit to current number.
	 * 
	 * @param digit				the digit to be add
	 */
	public void addDigit(String digit) {
		if (isResult) {
			reset();
		}
		
		rep.append(digit);
		
		isResult = false;
	}
	
	/**
	 * Append a period to current number if necessary.
	 */
	public void addPeriod() {
		if (!hasPeriod) {
			if (rep.length() == 0)
				rep.append('0');
			
			rep.append('.');
			hasPeriod = true;
		}
	}
	
	/**
	 * Clear the number.
	 */
	public void clear() {
		rep = new StringBuilder();
	}
	
	/**
	 * Backspace the number.
	 */
	public void backspace() {
		if (rep.length() == 0)
			isNegative = false;
		else {
			if (rep.charAt(rep.length() - 1) == '.')
				hasPeriod = false;
			
			rep.deleteCharAt(rep.length() - 1);
		}
	}
	
	/**
	 * Submit the number to upper area.
	 */
	public void submitNumber() {
		String val = rep.toString();
		
		if (val.length() == 0) val = "0";
		if (isNegative) val = "-" + val;
		
		Element e = new Element(ElementType.NUMBER, val);
		reset();
		upperArea.append(e);
	}
	
	/**
	 * Set the value according to the result.
	 * 
	 * @param result				the result
	 * @param isFinalResult			true if the result is the final result
	 */
	public void setResult(double result, boolean isFinalResult) {
		rep = new StringBuilder();
		if (result < 0)
			isNegative = true;
		else
			isNegative = false;
		
		isResult = true;
		this.isFinalResult = isFinalResult;
	}
	
	@Override
	public String toString() {
		if (rep.length() == 0)
			return "0";
		
		String res = "";
		boolean hasMetPeriod = !hasPeriod;
		int count = 0;
		
		// Adding ',' every three digits before meeting period
		for (int i = rep.length() - 1; i > -1; --i) {
			char c = rep.charAt(i);
			
			if (!hasMetPeriod) {
				if (c == '.')
					hasMetPeriod = true;
				
				res = c + res;
			} else if (i != 0 && ++count % 3 == 0) {
				res = "," + c + res;
			} else {
				res = c + res;
			}
		}
		
		System.out.println(res);
		return isNegative? "-" + res : res;
	}
}
