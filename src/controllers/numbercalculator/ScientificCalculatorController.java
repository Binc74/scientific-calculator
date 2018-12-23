package controllers.numbercalculator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.elements.*;
import models.upperarea.ScientificUpperArea;

public class ScientificCalculatorController extends BaseCalculatorController {
	public ScientificCalculatorController(Stage stage) {
		super(stage);
		
		// Initialize upper and lower area
		upperArea = new ScientificUpperArea();
		upperArea.setLowerArea(lowerArea);
		lowerArea.setUpperArea(upperArea);
	}
	
	@Override
	public void processDigit(ActionEvent event) {
		((ScientificUpperArea) upperArea).removeUnnecessaryData();
		super.processDigit(event);
	}
	
	@Override
	public void processPeriod() {
		((ScientificUpperArea) upperArea).removeUnnecessaryData();
		super.processPeriod();
	}
	
	@Override
	public void processFunc(ActionEvent event) {
		
	}
	
	@Override
	public void processOperator(Element.SubType subType, String rep) {		
		if (!lowerArea.isResult() || lowerArea.isFinalResult())
			lowerArea.submitNumber();
		
		upperArea.appendOperator(new Element(Element.Type.OP, subType, rep));
		lowerArea.setResult(upperArea.evaluate(), false);
		
		updateView();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		menuPaneController.setCurrType("Scientific");
	}
	
	@FXML public void processLeftParen() {
		((ScientificUpperArea) upperArea).addLeftParen();
		updateView();
	}
	
	@FXML public void processRightParen() {
		if (!lowerArea.isResult() || lowerArea.isFinalResult())
			lowerArea.submitNumber();
		
		((ScientificUpperArea) upperArea).addRightParen();
		updateView();
	}
}
