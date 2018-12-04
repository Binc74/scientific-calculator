package models.upperarea;

import java.util.Stack;

import models.elements.Element;
import models.elements.ElementType;

public class ScientificUpperArea extends BaseUpperArea {
	private Stack<Integer> parenPos;				// Use to keep track with the position of parenthesis
	private int lastLeftParen;
	
	public ScientificUpperArea() {
		super();
		
		parenPos = new Stack<> ();
		lastLeftParen = 0;
	}
	
	private boolean endWithRightParen() {
		return exp.size() > 0 && pendingOperator == null && 
				exp.getLast().type == ElementType.RIGHT_PAREN;
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
			exp.push(pendingOperator);		
			pendingOperator = null;
		}
		
		exp.push(e);
	}

	@Override
	public double evaluate() {
		return 0;		
	}
}
