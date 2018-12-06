package controllers.numbercalculator;

import java.net.URL;
import java.util.ResourceBundle;

import constants.Consts;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import models.upperarea.BasicUpperArea;

/**
 * Controller for Basic Calculator.
 * 
 * @author Bin Chen
 */
public class BasicCalculatorController extends BaseCalculatorController {
	public BasicCalculatorController(Stage stage) {
		super(stage);
		
		// Initialize upper and lower area
		upperArea = new BasicUpperArea();
		upperArea.setLowerArea(lowerArea);
		lowerArea.setUpperArea(upperArea);
	}
	
	@Override
	public void processFunc(ActionEvent event) {
		
	}
	
	@Override
	public void processOperator(String origin, String op) {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		menuPaneController.setCurrType("Basic");
	}
}
