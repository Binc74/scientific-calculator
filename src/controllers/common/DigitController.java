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
	
	private void updateView() {
		lower.setText(number.toString());
	}
	
	/**
	 * Process the digit button.
	 * 
	 * @param event				the fxml event
	 */
	public void processDigit(ActionEvent event) {
		String digit = ((Button) event.getSource()).getText();
		number.addDigit(digit);
		updateView();
	}
	
	/**
	 * Process period adding.
	 */
	public void processPeriod() {
		number.addPeriod();
		updateView();
	}
	
	/**
	 * Process entry clearing.
	 */
	public void clearEntry() {
		number.clear();
		updateView();
	}
}
