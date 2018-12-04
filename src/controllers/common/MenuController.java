package controllers.common;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuController {
	@FXML private Label currType;
	
	public MenuController() {
		
	}
	
	public void setCurrType(String type) {
		currType.setText(type);
	}
}
