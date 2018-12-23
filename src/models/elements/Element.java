package models.elements;

public class Element {

	public static enum Type {
		NUMBER,
		LEFT_PAREN,
		RIGHT_PAREN,
		OP,
		FUNC,
		GLOBAL_FUNC
	}
	
	public static enum SubType {
		ADD,
		MINUS,
		SUBTRACT,
		MULT,
		MOD,
		DIVIDE,
		POWER
	}
	
	public Type type;
	public SubType subType;
	public String rep;				// The representation of the element
	public String val;				// The value of the element
	
	public Element(Type type, SubType subType, String rep) {
		this.type = type;
		this.subType = subType;
		this.rep = rep;
		this.val = null;
	}
	
	public Element(Type type, SubType subType, String rep, String val) {
		this.type = type;
		this.subType = subType;
		this.rep = rep;
		this.val = val;
	}
	
	public Element(Type type, String rep, String val) {
		this.type = type;
		this.subType = null;
		this.rep = rep;
		this.val = val;
	}
	
	public Element(Type type, String rep) {
		this.type = type;
		this.subType = null;
		this.rep = rep;
		this.val = null;
	}
}
