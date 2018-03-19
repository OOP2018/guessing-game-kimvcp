package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for the Counter buttons user interface.
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class GameController extends NumberGame {

	@FXML
	Label label;
	@FXML
	TextField textfield1;

	private NumberGame game;

	public void setGame(NumberGame game) {
		this.game = game;
	}

	public void handleGuess(ActionEvent event) {
		int guessingNumber;
		try {
			guessingNumber = Integer.parseInt(textfield1.getText());
		} catch (NumberFormatException e) {
			label.setText("Input should be a number.");
			textfield1.clear();
			return;
		}
		try {
			boolean isCorrect = game.guess(guessingNumber);
			if (isCorrect) {
				label.setText("Congratuation! You won the game");
			} else {
				label.setText(game.getMessage());
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		textfield1.clear();

	}

}
