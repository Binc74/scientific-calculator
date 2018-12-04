package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import controllers.common.CoreEventController;
import controllers.common.MenuController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * The base class for all main controllers.
 * 
 * @author Bin Chen
 */
public abstract class BaseMainController implements Initializable {
	protected Stage stage;
	
	@FXML protected CoreEventController topPaneController;
	@FXML protected MenuController menuPaneController;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		topPaneController.setupStage(stage);
	}
}
