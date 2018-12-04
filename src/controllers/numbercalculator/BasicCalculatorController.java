package controllers.numbercalculator;

import java.net.URL;
import java.util.ResourceBundle;

import constants.Consts;
import controllers.BaseMainController;
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
	public void processOperator(ActionEvent event) {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		menuPaneController.setCurrType("Basic");
	}
}
