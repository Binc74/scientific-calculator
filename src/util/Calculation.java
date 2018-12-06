package util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import models.elements.Element;
import models.elements.ElementType;

/**
 * Utility class for calculation.
 * 
 * @author Bin Chen
 */
public class Calculation {
	private Set<String> addOpSet;
	private Set<String> multiOpSet;
	
	
	public Calculation() {
		addOpSet = new HashSet<> ();
		multiOpSet = new HashSet<> ();
		
		addOpSet.add("+");
		addOpSet.add("-");
		
		multiOpSet.add("Mod");
		multiOpSet.add("*");
		multiOpSet.add("/");
		multiOpSet.add("^");
	}
	
	/**
	 * Calculate value of expression.
	 * 
	 * cfg:	
	 * expr -> term { addOp term }
	 * term -> factor { multOp factor }
	 * factor -> sub-factor | number
	 * sub-factor -> param | function 
	 * param -> ( expr )
	 * function -> func param )
	 * func -> neg( | root( | log( | 10^( | sin( | cos( | 
	 * addOp -> + | -
	 * multOp -> * | / | % | ^
	 * 
	 * @assumes	the tokens strictly follow the cfg
	 * 
	 * @param tokens			the expression
	 * @return					the value
	 */
	public double calculateExpression(LinkedList<Element> tokens) {
		if (tokens.size() == 0)
			return 0;

		return parseExpr(tokens);
	}
	
	/**
	 * Get the value of the expression.
	 *
	 * @param tokens			the expression
	 * @return					the result
	 */
	private double parseExpr(LinkedList<Element> tokens) {
		double val = parseTerm(tokens);
		
		while (tokens.size() > 0 && addOpSet.contains(tokens.peekFirst().val)) {
			String op = tokens.removeFirst().val;
			double val2 = parseTerm(tokens);
			
			switch(op) {
			case "+":
				val += val2;
				break;
			case "-":
				val -= val2;
				break;
			}
		}
		
		return val;
	}
	
	/**
	 * Get the value of the term.
	 *
	 * @param tokens			the expression that starts with term
	 * @return 					the result
	 */
	private double parseTerm(LinkedList<Element> tokens) {
		double val = parseFactor(tokens);
		
		while (tokens.size() > 0 && multiOpSet.contains(tokens.peekFirst().val)) {
			String op = tokens.removeFirst().val;
			double val2 = parseFactor(tokens);
			
			switch(op) {
			case "*":
				val *= val2;
				break;
			case "/":
				val /= val2;
				break;
			case "Mod":
				val %= val2;
				break;
			case "^":
				val = Math.pow(val, val2);
				break;
			}
		}
		
		return val;
	}
	
	/**
	 * Get the value of the factor.
	 *
	 * @param tokens				the expression starts with factor
	 * @return 						the result
	 */
	private double parseFactor(LinkedList<Element> tokens) {
		if (tokens.peekFirst().type == ElementType.NUMBER) {
			return Double.parseDouble(tokens.removeFirst().val);
		}
			
		return parseSubFactor(tokens);
	}
	
	/**
	 * Get the value of the subfactor.
	 *
	 * @param tokens				the expression that starts with subfactor
	 * @return 						the result
	 */
	private double parseSubFactor(LinkedList<Element> tokens) {
		if (tokens.peekFirst().type == ElementType.LEFT_PAREN)
			return parseParam(tokens);
		
		return parseFunction(tokens);
	}
	
	/**
	 * Get the value inside the parameter.
	 *
	 * @param tokens				The expression
	 * @return						the result
	 */
	private double parseParam(LinkedList<Element> tokens) {
		if (tokens.removeFirst().type != ElementType.LEFT_PAREN)
			System.err.println("error: can't find '('");
		double val = parseExpr(tokens);
		
		if (tokens.removeFirst().type != ElementType.RIGHT_PAREN)
			System.err.println("error: can't find ')'");
		
		return val;
	}
	
	/**
	 * Get the value of the function.
	 *
	 * @param tokens				The expression
	 * @return 						the result
	 */
	private double parseFunction(LinkedList<Element> tokens) {
		String func = tokens.removeFirst().val;
		double param = parseExpr(tokens);
		
		if (tokens.removeFirst().type != ElementType.RIGHT_PAREN)
			System.err.println("error: can't find ')'");
		
		switch (func) {
		
		}
		
		return param;
	}
}
