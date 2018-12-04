package models.upperarea;

import models.LowerArea;
import models.elements.Element;

public interface UpperArea {
	/**
	 * Append the element to the end.
	 * 
	 * @param e						the element
	 */
	void append(Element e);
	
	/**
	 * Setter method for lowerArea.
	 * 
	 * @param lowerArea				the lower area
	 */
	void setLowerArea(LowerArea lowerArea);
	
	/**
	 * Clear all data.
	 */
	void clear();
	
	/**
	 * Append the operator to the end.
	 * 
	 * @requires					e.type == OP
	 */
	void appendOperator(Element e);
	
	/**
	 * Evaluate current expression, and set the result to lower area.
	 * 
	 * @return						the result
	 */
	double evaluate();
	
	/**
	 * Return the string representation of the expression.
	 * 
	 * @return						the string representation
	 */
	String toString();
}
