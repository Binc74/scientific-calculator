package models.upperarea;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import models.LowerArea;
import models.elements.Element;
import models.upperarea.states.BasicUpperAreaState;
import models.upperarea.states.UpperAreaState;
import models.upperarea.states.UpperAreaStates;

/**
 * Model for the upper display area of the calculator.
 * 
 * @author Bin Chen
 */
public class UpperArea {	
	private LowerArea lowerArea;
	
	public Queue<Element> exp;
	public Queue<Element> memo;
	
	private Map<UpperAreaStates, UpperAreaState> states;
	private UpperAreaStates currState;
	
	public UpperArea() {
		exp = new LinkedList<> ();
		memo = new LinkedList<> ();
		states = new HashMap<> ();
		initializeStates();
	}
	
	private void initializeStates() {
		states.put(UpperAreaStates.BASIC, new BasicUpperAreaState(this));
		//states.put(UpperAreaStates.SCIENTIFIC, new BasicUpperAreaState(this));
	}
	
	public void append(Element e) {
		states.get(UpperAreaStates.BASIC).append(e);
	}
	
	/**
	 * A setter method.
	 * 
	 * @param lowerArea			the lower area
	 */
	public void setLowerArea(LowerArea lowerArea) {
		this.lowerArea = lowerArea;
	}
	
	
}
