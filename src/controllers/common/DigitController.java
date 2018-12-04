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
	
	public DigitController(LowerArea number) {
		this.number = number;
	}
	
	/**
	 * Process the digit button.
	 * 
	 * @param event				the fxml event
	 */
	public void processDigit(ActionEvent event) {
		String digit = ((Button) event.getSource()).getText();
		number.addDigit(digit);
	}
	
	/**
	 * Process period adding.
	 */
	public void processPeriod() {
		number.addPeriod();
	}
	
	/**
	 * Process entry clearing.
	 */
	public void clearEntry() {
		number.clear();
	}
	
	/**
	 * Process backspace event.
	 */
	public void processBackspace() {
		number.backspace();
	}
}
