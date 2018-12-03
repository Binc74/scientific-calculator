package models.elements;

public class Element {

	public ElementType type;
	public String val;
	
	public Element(ElementType type) {
		this.type = type;
	}
	
	public void setVal(String val) {
		this.val = val;
	}
}
