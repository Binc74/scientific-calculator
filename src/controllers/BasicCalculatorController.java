package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import constants.Consts;
import controllers.common.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import models.LowerArea;
import models.upperarea.BasicUpperArea;
import models.upperarea.UpperArea;

/**
 * Controller for Basic Calculator.
 * 
 * @author Bin Chen
 */
public class BasicCalculatorController extends BaseController {
	
	private DigitController digitContr;
	@FXML private DispController dispPaneController;
	
	private UpperArea upperArea;
	private LowerArea lowerArea;
	
	public BasicCalculatorController(Stage stage) {
		this.stage = stage;
		
		// Initialize upper and lower area
		upperArea = new BasicUpperArea();
		lowerArea = new LowerArea();
		upperArea.setLowerArea(lowerArea);
		lowerArea.setUpperArea(upperArea);
	}
	
	private void updateView() {
		dispPaneController.updateView();
	}
	
	@FXML
	public void processDigit(ActionEvent event) {
		digitContr.processDigit(event);
	}

	@FXML
	public void processPeriod() {
		digitContr.processPeriod();
	}
	
	@FXML
	public void clearEntry() {
		digitContr.clearEntry();
	}
	
	@FXML
	public void processBackspace() {
		digitContr.processBackspace();
	}
	
	@FXML
	public void submitNumber() {
		lowerArea.submitNumber();
		updateView();
	}
	
	@FXML
	public void processFunc(ActionEvent event) {
		
	}
	
	@FXML
	public void processOperator(ActionEvent event) {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		dispPaneController.setLowerArea(lowerArea);
		dispPaneController.setUpperArea(upperArea);
		digitContr = new DigitController(lowerArea, dispPaneController.getLowerDisp(), 
				dispPaneController.getUpperDisp());
	}
}
