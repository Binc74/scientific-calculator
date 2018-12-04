package controllers.numbercalculator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import models.upperarea.BasicUpperArea;

public class ScientificCalculatorController extends BaseCalculatorController {
	public ScientificCalculatorController(Stage stage) {
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
	public void processOperator(ActionEvent event) {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		menuPaneController.setCurrType("Scientific");
	}
}
