package models.upperarea;

import java.util.LinkedList;
import java.util.Stack;

import models.elements.Element;
import util.Calculation;

public class ScientificUpperArea extends BaseUpperArea {
	private Stack<Integer> parenPos;		// Use to keep track with the position of rhe left parenthesis
	private int lastLeftParen;				// The last position of the left parenthesis
	
	private Calculation calculation;
	
	public ScientificUpperArea() {
		super();
		
		calculation = new Calculation();
		parenPos = new Stack<> ();
		lastLeftParen = 0;
	}
	
	private boolean endWithRightParen() {
		return exp.size() > 0 && pendingOperator == null && 
				exp.getLast().type == Element.Type.RIGHT_PAREN;
	}
	
	private LinkedList<Element> sublistStartFrom(int from) {
		LinkedList<Element> ans = new LinkedList<> ();
		
		for (Element e: exp) {
			if (from-- <= 0) {
				ans.addLast(e);
			}
		}
		
		return ans;
	}
	
	private LinkedList<Element> getEvalList() {
		if (lastLeftParen > 0) {
			if (exp.peekLast().type == Element.Type.RIGHT_PAREN)
				return sublistStartFrom(lastLeftParen);
			else
				return sublistStartFrom(lastLeftParen + 1);
		}
		
		return sublistStartFrom(0);
	}
	
	public void addLeftParen() {
		if (pendingOperator != null) {
			exp.addLast(pendingOperator);
			pendingOperator = null;
		}
		
		exp.addLast(new Element(Element.Type.LEFT_PAREN, "("));
		
		int currParenPos = exp.size() - 1;
		parenPos.push(currParenPos);
		lastLeftParen = currParenPos;
	}
	
	public void addRightParen() {
		exp.addLast(new Element(Element.Type.RIGHT_PAREN, ")"));
		lastLeftParen = parenPos.pop();
	}
	
	public void removeUnnecessaryData() {
		// If end with right paren, the content within the last set of paren should be delete
		if (endWithRightParen()) {
			Element temp = exp.removeLast();
			
			while (temp.type != Element.Type.LEFT_PAREN) {
				temp = exp.removeLast();
			}
		}
	}
	
	@Override
	public void appendOperator(Element op) {
		assert op.type == Element.Type.OP: "error: element type is not operator";
		
		if (parenPos.size() > 0)
			lastLeftParen = parenPos.peek();
		else
			lastLeftParen = 0;
		
		this.pendingOperator = op;
	}
	
	@Override
	public void append(Element e) {
		if (pendingOperator != null) {
			exp.addLast(pendingOperator);		
			pendingOperator = null;
		}
		
		exp.addLast(e);
	}
	
	@Override
	public double evaluate() {
		return calculation.calculateExpression(getEvalList());
	}
}
