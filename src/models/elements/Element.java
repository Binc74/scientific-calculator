package models.elements;

public class Element {

	public ElementType type;
	public String rep;				// The representation of the element
	public String val;				// The value of the element
	
	public Element(ElementType type, String rep, String val) {
		this.type = type;
		this.rep = rep;
		this.val = val;
	}
}
