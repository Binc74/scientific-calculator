package controllers.common;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import models.LowerArea;

/**
 * Controller for digit buttons.
 * 
 * @author Bin Chen
 */
public class DigitController {
	
	private LowerArea number;
	private Label lower;
	private TextFlow upper;
	
	public DigitController(LowerArea number, Label lower, TextFlow upper) {
		this.number = number;
		this.lower = lower;
		this.upper = upper;
	}
	
	/**
	 * Process the digit button.
	 * 
	 * @param event				the fxml event
	 */
	public void processDigit(ActionEvent event) {
		String digit = ((Button) event.getSource()).getText();
		number.addDigit(digit);
		lower.setText(number.toString());
	}
	
	
	public void processPeriod() {
		
	}
}
