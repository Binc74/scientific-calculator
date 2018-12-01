package models;

/**
 * Model for the lower display area of the calculator.
 * 
 * @author Bin Chen
 */
public class LowerArea {	
	private StringBuilder rep;		// The string representation of the number
	private boolean hasPeriod;		// True if this number has period
	private boolean isTemp;			// True if this number is set by previous result
	private boolean isNegative;		// True if this number is negative
	
	public LowerArea() {
		rep = new StringBuilder();
		hasPeriod = false;
		isTemp = false;
		isNegative = false;
	}
	
	/**
	 * Append a digit to current number.
	 * 
	 * @param digit				the digit to be add
	 */
	public void addDigit(String digit) {
		if (isTemp) {
			rep = new StringBuilder();
			hasPeriod = false;
			isNegative = false;			
		}
		
		rep.append(digit);
		
		isTemp = false;
	}
	
	/**
	 * Append a period to current number if necessary.
	 */
	public void addPeriod() {
		if (!hasPeriod) {
			if (rep.length() == 0)
				rep.append('0');
			
			rep.append('.');
			hasPeriod = true;
		}
	}
	
	/**
	 * Clear the number.
	 */
	public void clear() {
		rep = new StringBuilder();
	}
	
	/**
	 * Backspace the number.
	 */
	public void backspace() {
		if (rep.length() == 0)
			isNegative = false;
		else {
			rep.deleteCharAt(rep.length() - 1);
		}
	}
	
	@Override
	public String toString() {
		if (rep.length() == 0)
			return "0";
		
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
