package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.common.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import models.LowerArea;
import models.UpperArea;

/**
 * Controller for Basic Calculator.
 * 
 * @author Bin Chen
 */
public class BasicCalculatorController extends BaseController {
	
	private DigitController digitContr;
	
	private UpperArea upperArea;
	private LowerArea lowerArea;
	
	@FXML private TextFlow upperText;
	@FXML private TextFlow lowerText;
	
	public BasicCalculatorController(Stage stage) {
		this.stage = stage;
		upperArea = new UpperArea();
		lowerArea = new LowerArea();
		digitContr = new DigitController(lowerArea);
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
