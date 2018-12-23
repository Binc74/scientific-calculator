package models.upperarea;

import java.util.Deque;
import java.util.LinkedList;

import models.elements.Element;
import models.lowerarea.LowerArea;


/**
 * Model for the upper display area of the calculator.
 * 
 * @author Bin Chen
 */
public abstract class BaseUpperArea implements UpperArea {	
	private LowerArea lowerArea;
	
	public LinkedList<Element> exp;

	protected Element pendingOperator;
	
	public BaseUpperArea() {
		exp = new LinkedList<> ();
		pendingOperator = null;
	}
	
	public abstract void append(Element e);
	
	/**
	 * A setter method.
	 * 
	 * @param lowerArea			the lower area
	 */
	public void setLowerArea(LowerArea lowerArea) {
		this.lowerArea = lowerArea;
	}
	
	public void clear() {
		exp.clear();
		pendingOperator = null;
	}
	
	public abstract void appendOperator(Element e);
	
	public abstract double evaluate();
	
	@Override
	public String toString() {
		StringBuilder ans = new StringBuilder();
		
		for (Element e: exp) {
			ans.append(e.rep);
			ans.append(" ");
		}

		if (ans.length() > 0)
			ans.deleteCharAt(ans.length() - 1);
		
		if (pendingOperator != null)
			ans.append(" " + pendingOperator.rep);
		
		
		return ans.toString();
	}
}
