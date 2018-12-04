package models.upperarea;

import java.util.LinkedList;
import java.util.Queue;

import models.LowerArea;
import models.elements.Element;


/**
 * Model for the upper display area of the calculator.
 * 
 * @author Bin Chen
 */
public abstract class BaseUpperArea implements UpperArea {	
	private LowerArea lowerArea;
	
	public Queue<Element> exp;
	public Queue<Element> memo;
	
	public BaseUpperArea() {
		exp = new LinkedList<> ();
		memo = new LinkedList<> ();
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
	
	@Override
	public String toString() {
		String ans = "";
		
		for (Element e: exp) {
			ans += e.val + " ";
		}
		System.out.println(exp.size());
		return ans;
	}
}
