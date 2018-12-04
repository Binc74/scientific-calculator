package main;
	
import controllers.numbercalculator.BasicCalculatorController;
import controllers.numbercalculator.ScientificCalculatorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;

/**
 * The main class.
 * 
 * @author Bin Chen
 */
public class CalculatorMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/ScientificView.fxml"));
			ScientificCalculatorController contr = new ScientificCalculatorController(primaryStage);
			loader.setController(contr);
			Scene scene = new Scene(loader.load());
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
