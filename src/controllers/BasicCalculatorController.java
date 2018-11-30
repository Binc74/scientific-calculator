package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.common.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Controller for Basic Calculator.
 * 
 * @author Bin Chen
 */
public class BasicCalculatorController extends BaseController {
	
	private DigitController digitContr;
	
	public BasicCalculatorController(Stage stage) {
		this.stage = stage;
		digitContr = new DigitController();
	}
	
	@FXML
	public void processDigit(ActionEvent event) {
		digitContr.processDigit(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		super.initialize(location, resources);
	}	
	
}
