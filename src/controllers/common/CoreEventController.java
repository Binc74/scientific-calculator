package controllers.common;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller for core events.
 * 
 * @author Bin Chen
 */
public class CoreEventController {
	@FXML protected Button btnClose;
	
	public CoreEventController() {
	}
		
	@FXML public void processExit() {
		System.out.println("exit");
		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
	}
	
	@FXML public void processMinimize(ActionEvent event) {
		
	}
	
	@FXML public void processDragging() {
		
	}
}
