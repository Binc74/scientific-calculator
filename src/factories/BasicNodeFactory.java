package factories;

import constants.Consts;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * A scene node factory
 * 
 * @author Bin Chen
 */
public class BasicNodeFactory {
	
	public BasicNodeFactory() {
	}
	
	/**
	 * Create a JavaFX label with given configuration.
	 * 
	 * @param text				the text display in the label
	 * @param color				the color of the label
	 * @param size				the font size for label
	 * 
	 * @return 					the label
	 */
	public Label createLabel(String text, Color color, int size) {
		Label lb = new Label(text);
		
		lb.setTextFill(color);
		lb.setFont(new Font(Consts.FONT_NAME, size));
		
		return lb;
	}
}