package models.upperarea;

import java.util.LinkedList;
import java.util.Stack;

import models.elements.Element;
import models.elements.ElementType;
import util.Calculation;

public class ScientificUpperArea extends BaseUpperArea {
	private Stack<Integer> parenPos;				// Use to keep track with the position of parenthesis
	private int lastLeftParen;
	
	private Calculation calculation;
	
	public ScientificUpperArea() {
		super();
		
		calculation = new Calculation();
		parenPos = new Stack<> ();
		lastLeftParen = 0;
	}
	
	private boolean endWithRightParen() {
		return exp.size() > 0 && pendingOperator == null && 
				exp.getLast().type == ElementType.RIGHT_PAREN;
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
			if (exp.peekLast().type == ElementType.RIGHT_PAREN)
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
		
		exp.addLast(new Element(ElementType.LEFT_PAREN, "(", "("));
		
		int currParenPos = exp.size() - 1;
		parenPos.push(currParenPos);
		lastLeftParen = currParenPos;
	}
	
	public void addRightParen() {
		exp.addLast(new Element(ElementType.RIGHT_PAREN, ")", ")"));
		lastLeftParen = parenPos.pop();
	}
	
	@Override
	public void appendOperator(Element op) {
		assert op.type == ElementType.OP: "error: element type is not operator";
		
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
