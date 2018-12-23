package util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import models.elements.Element;

/**
 * Utility class for calculation.
 * 
 * @author Bin Chen
 */
public class Calculation {
	private Set<Element.SubType> addOpSet;
	private Set<Element.SubType> multiOpSet;
	
	
	public Calculation() {
		addOpSet = new HashSet<> ();
		multiOpSet = new HashSet<> ();
		
		addOpSet.add(Element.SubType.ADD);
		addOpSet.add(Element.SubType.MINUS);
		
		multiOpSet.add(Element.SubType.MOD);
		multiOpSet.add(Element.SubType.MULT);
		multiOpSet.add(Element.SubType.DIVIDE);
		multiOpSet.add(Element.SubType.POWER);
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
	 * func -> neg( | root( | log( | 10^( | sin( | cos( | ...
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
		
		while (tokens.size() > 0 && addOpSet.contains(tokens.peekFirst().subType)) {
			Element.SubType op = tokens.removeFirst().subType;
			double val2 = parseTerm(tokens);
			
			switch(op) {
			case ADD:
				val += val2;
				break;
			case MINUS:
				val -= val2;
				break;
			default:
				System.err.println("error: can't find add-op");
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
		
		while (tokens.size() > 0 && multiOpSet.contains(tokens.peekFirst().subType)) {
			Element.SubType op = tokens.removeFirst().subType;
			double val2 = parseFactor(tokens);
			
			switch(op) {
			case MULT:
				val *= val2;
				break;
			case DIVIDE:
				val /= val2;
				break;
			case MOD:
				val %= val2;
				break;
			case POWER:
				val = Math.pow(val, val2);
				break;
			default:
				System.err.println("error: can't find multi-op");
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
		if (tokens.peekFirst().type == Element.Type.NUMBER) {
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
		if (tokens.peekFirst().type == Element.Type.LEFT_PAREN)
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
		if (tokens.removeFirst().type != Element.Type.LEFT_PAREN)
			System.err.println("error: can't find '('");
		double val = parseExpr(tokens);
		
		if (tokens.removeFirst().type != Element.Type.RIGHT_PAREN)
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
		Element.SubType func = tokens.removeFirst().subType;
		double param = parseExpr(tokens);
		
		if (tokens.removeFirst().type != Element.Type.RIGHT_PAREN)
			System.err.println("error: can't find ')'");
		
		switch (func) {
		case NEG:
			return -param;
		case TENX:
			return Math.pow(10, param);
		case LOG:
			return Math.log10(param);
		case TAN:
			return Math.tan(param);
		case SIN:
			return Math.sin(param);
		case COS:
			return Math.cos(param);
		case SQUARE:
			return param * param;
		case ROOT:
			return Math.sqrt(param);
		case FACTORIAL:
			return factorial((int) Math.floor(param));
		default:
			System.err.println("error: can't find the function");
			break;
		}
		
		return 0;
	}
	
	private int factorial(int num) {
		int ans = 1;
		
		for (int i = 1; i <= num; ++i) {
			int temp = ans * i;
			
			// Check overflow
			if (temp < ans)
				return -1;
			
			ans = temp;
		}
		
		return ans;
	}
}
