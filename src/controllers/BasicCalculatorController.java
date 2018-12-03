package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import constants.Consts;
import controllers.common.*;
import factories.BasicNodeFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import models.LowerArea;
import models.upperarea.UpperArea;

/**
 * Controller for Basic Calculator.
 * 
 * @author Bin Chen
 */
public class BasicCalculatorController extends BaseController {
	
	private DigitController digitContr;
	private BasicNodeFactory nf;
	
	private UpperArea upperArea;
	private LowerArea lowerArea;
	
	@FXML private Label upperText;
	@FXML private Label lowerText;
	
	public BasicCalculatorController(Stage stage) {
		this.stage = stage;
		
		// Initialize upper and lower area
		upperArea = new UpperArea();
		lowerArea = new LowerArea();
		upperArea.setLowerArea(lowerArea);
		lowerArea.setUpperArea(upperArea);
		nf = new BasicNodeFactory();
	}
	
	private void updateView() {
		lowerText.setText(lowerArea.toString());
		upperText.setText(upperArea.toString());
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		digitContr = new DigitController(lowerArea, lowerText, upperText);
		lowerText.setTextFill(Consts.NORMAL_COLOR);
		lowerText.setFont(new Font(Consts.FONT_NAME, Consts.LOWER_FONT_SIZE));
		lowerText.setText(Consts.INIT_VALUE);
	}
}
