package controllers.common;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.lowerarea.LowerArea;
import models.upperarea.UpperArea;

/**
 * Controller for display area.
 * 
 * @author Bin Chen
 */
public class DispController {
	@FXML private Label upperDisp;
	@FXML private Label lowerDisp;
	
	private UpperArea upperArea;
	private LowerArea lowerArea;
	
	public DispController() {		
	}
	
	// Getter and setter methods
	
	public Label getUpperDisp() {
		return upperDisp;
	}
	
	public Label getLowerDisp() {
		return lowerDisp;
	}
	
	public void setUpperArea(UpperArea upperArea) {
		this.upperArea = upperArea;
	}
	
	public void setLowerArea(LowerArea lowerArea) {
		this.lowerArea = lowerArea;
	}
	
	public void updateView() {
		lowerDisp.setText(lowerArea.toString());
		upperDisp.setText(upperArea.toString());
	}
}
