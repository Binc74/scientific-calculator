package models;

/**
 * Model for the lower display area.
 * 
 * @author Bin Chen
 */
public class LowerArea {	
private StringBuilder rep;			// The string representation of the number
	private boolean hasPeriod;		// True if this number has period
	private boolean isTemp;			// True if this number is set by previous result
	private boolean isNegative;		// True if this number is negative
	
	public LowerArea() {
		rep = new StringBuilder();
		hasPeriod = false;
		isTemp = false;
		isNegative = false;
	}
	
	public void addDigit(String digit) {
		if (isTemp) {
			rep = new StringBuilder();
			hasPeriod = false;
			isNegative = false;			
		}
		
		rep.append(digit);
		
		isTemp = false;
	}
	
	public void addPeriod() {
		if (!hasPeriod) {
			if (rep.length() == 0)
				rep.append('0');
			
			rep.append('.');
			hasPeriod = true;
		}
	}
	
	@Override
	public String toString() {
		String res = "";
		boolean hasMetPeriod = !hasPeriod;
		int count = 0;
		
		// Adding ',' every three digits
		for (int i = rep.length() - 1; i > -1; --i) {
			char c = rep.charAt(i);
			
			if (!hasMetPeriod) {
				if (c == '.')
					hasMetPeriod = true;
				
				res = c + res;
			} else if (i != 0 && ++count % 3 == 0) {
				res = "," + c + res;
			} else {
				res = c + res;
			}
		}
		
		System.out.println(res);
		return isNegative? "-" + res : res;
	}
}
