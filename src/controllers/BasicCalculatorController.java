package controllers;

import controllers.common.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Controller for Basic Calculator.
 * 
 * @author Bin Chen
 */
public class BasicCalculatorController {
	
	private DigitController digitContr;
	
	public BasicCalculatorController() {
		digitContr = new DigitController();
	}
	
	@FXML
	public void processDigit(ActionEvent event) {
		digitContr.processDigit(event);
	}
	
	
}
