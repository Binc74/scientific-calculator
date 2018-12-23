package controllers.numbercalculator;

import java.net.URL;
import java.util.ResourceBundle;

import constants.Consts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.elements.*;
import models.upperarea.ScientificUpperArea;

public class ScientificCalculatorController extends BaseCalculatorController {
	private ScientificUpperArea ua;
	
	public ScientificCalculatorController(Stage stage) {
		super(stage);
		
		// Initialize upper and lower area
		upperArea = new ScientificUpperArea();
		ua = (ScientificUpperArea) upperArea;
		ua.setLowerArea(lowerArea);
		lowerArea.setUpperArea(ua);
	}
	
	@Override
	public void processDigit(ActionEvent event) {
		ua.removeUnnecessaryData();
		super.processDigit(event);
	}
	
	@Override
	public void processPeriod() {
		ua.removeUnnecessaryData();
		super.processPeriod();
	}
	
	@Override
	public void processFunc(Element.SubType subType, String rep) {
		Element func = new Element(Element.Type.FUNC, subType, rep);
		
		if (ua.endWithRightParen())
			ua.addFunction(func);
		else
			lowerArea.addFunction(func);
			
		lowerArea.setResult(ua.evaluate(), false);
		
		updateView();
	}
	
	@Override
	public void processOperator(Element.SubType subType, String rep) {		
		if (!lowerArea.isResult() || lowerArea.isFinalResult())
			lowerArea.submitNumber();
		
		ua.appendOperator(new Element(Element.Type.OP, subType, rep));
		lowerArea.setResult(ua.evaluate(), false);
		
		updateView();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		menuPaneController.setCurrType("Scientific");
	}
	
	@FXML public void processLeftParen() {
		ua.addLeftParen(null, null);
		updateView();
	}
	
	@FXML public void processRightParen() {
		if (!lowerArea.isResult() || lowerArea.isFinalResult())
			lowerArea.submitNumber();
		
		ua.addRightParen();
		updateView();
	}
	
	@FXML public void process10x() {
		processFunc(Element.SubType.TENX, "10^(");
	}
	
	@FXML public void processLog() {
		processFunc(Element.SubType.LOG, "log(");
	}
	
	@FXML public void processPower() {
		processOperator(Element.SubType.POWER, "^");
	}
	
	@FXML public void processTan() {
		processFunc(Element.SubType.TAN, "tan(");
	}
	
	@FXML public void processCos() {
		processFunc(Element.SubType.COS, "cos(");
	}
	
	@FXML public void processSin() {
		processFunc(Element.SubType.SIN, "sin(");
	}
	
	@FXML public void processSquare() {
		processFunc(Element.SubType.SQUARE, "sqr(");
	}
	
	@FXML public void processFactorial() {
		processFunc(Element.SubType.FACTORIAL, "fact(");
	}
	
	@FXML public void processRoot() {
		processFunc(Element.SubType.ROOT, "root(");
	}
}
