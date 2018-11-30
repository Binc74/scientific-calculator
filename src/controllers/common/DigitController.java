package controllers.common;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
		System.out.println("Pressed " + digit);
	}
}
