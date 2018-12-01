package controllers.common;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controller for core events.
 * 
 * @author Bin Chen
 */
public class CoreEventController {
	private double xOffset;
	private double yOffset;
	
	private Stage stage;
	
	public CoreEventController() {
	}
	
	/**
	 * A setter method that set the stage.
	 * 
	 * @param stage			the javafx stage
	 */
	public void setupStage(Stage stage) {
		this.stage = stage;
	}
	
	/**
	 * Process close window event.
	 */
	@FXML public void processExit() {
		System.out.println("exit");
		stage.close();
	}
	
	/**
	 * Process minimize window event.
	 */
	@FXML public void processMinimize() {
		System.out.println("minimize");
		stage.setIconified(true);
	}
	
	/**
	 * Process mouse pressed event.
	 * 
	 * @param event				the mouse event
	 */
	@FXML public void processMousePressed(MouseEvent event) {
		System.out.println("Dragging");
		xOffset = event.getSceneX();
		yOffset = event.getSceneY();
	}
	
	/**
	 * Process mouse dragged event.
	 * 
	 * @param event				the mouse event
	 */
	@FXML public void processMouseDragged(MouseEvent event) {
		stage.setX(event.getScreenX() - xOffset);
		stage.setY(event.getScreenY() - yOffset);	
	}
}
