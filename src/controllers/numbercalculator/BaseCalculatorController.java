package controllers.numbercalculator;

import java.net.URL;
import java.util.ResourceBundle;

import constants.Consts;
import controllers.BaseMainController;
import controllers.common.DigitController;
import controllers.common.DispController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.elements.Element;
import models.lowerarea.LowerArea;
import models.upperarea.UpperArea;

/**
 * Base controller class for calculator controller. 
 * 
 * @author Bin Chen
 */
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
	
	/**
	 * Update the display area view.
	 */
	protected void updateView() {
		dispPaneController.updateView();
	}
	
	/**
	 * Process the event for pressing digit buttons.
	 * 
	 * @param event				
	 */
	@FXML public void processDigit(ActionEvent event) {
		digitContr.processDigit(event);
		updateView();
	}

	/**
	 * 
	 */
	@FXML public void processPeriod() {
		digitContr.processPeriod();
		updateView();
	}
	
	@FXML public void clearEntry() {
		digitContr.clearEntry();
		updateView();
	}
	
	@FXML public void clearAll() {
		digitContr.clearEntry();
		upperArea.clear();
		updateView();
	}
	
	@FXML public void processBackspace() {
		digitContr.processBackspace();
		updateView();
	}
	
	@FXML public void submitExpr() {
		lowerArea.submitNumber();
		lowerArea.setResult(upperArea.evaluate(), true);
		upperArea.clear();
		updateView();
	}
	
	public abstract void processFunc(Element.SubType subType, String rep);
	
	public abstract void processOperator(Element.SubType subType, String rep);
	
	protected String getButtonStr(ActionEvent e) {
		return ((Button) e.getSource()).getText();
	}
	
	@FXML public void processAdd(ActionEvent event) {
		processOperator(Element.SubType.ADD, getButtonStr(event));
	}
	
	@FXML public void processMinus(ActionEvent event) {
		processOperator(Element.SubType.MINUS, getButtonStr(event));
	}
	
	@FXML public void processMult(ActionEvent event) {
		processOperator(Element.SubType.MULT, getButtonStr(event));
	}
	
	@FXML public void processDivide(ActionEvent event) {
		processOperator(Element.SubType.DIVIDE, getButtonStr(event));
	}
	
	@FXML public void processMod(ActionEvent event) {
		processOperator(Element.SubType.MOD, getButtonStr(event));
	}	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		dispPaneController.setLowerArea(lowerArea);
		dispPaneController.setUpperArea(upperArea);
		digitContr = new DigitController(lowerArea);
	}
}
