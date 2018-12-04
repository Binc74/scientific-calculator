package controllers.numbercalculator;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.BaseMainController;
import controllers.common.DigitController;
import controllers.common.DispController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import models.LowerArea;
import models.upperarea.BasicUpperArea;
import models.upperarea.UpperArea;

public abstract class BaseCalculatorController extends BaseMainController {

	protected DigitController digitContr;
	@FXML protected DispController dispPaneController;
	
	protected UpperArea upperArea;
	protected LowerArea lowerArea;
	
	public BaseCalculatorController(Stage stage) {
		super();
		this.stage = stage;
		
		lowerArea = new LowerArea();
	}
	
	protected void updateView() {
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
	public abstract void processFunc(ActionEvent event);
	
	@FXML
	public abstract void processOperator(ActionEvent event);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		dispPaneController.setLowerArea(lowerArea);
		dispPaneController.setUpperArea(upperArea);
		digitContr = new DigitController(lowerArea, dispPaneController.getLowerDisp(), 
				dispPaneController.getUpperDisp());
	}
}
