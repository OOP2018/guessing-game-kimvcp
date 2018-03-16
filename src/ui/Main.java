package ui;

import counter.CounterView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		NumberGame game = new KimGame(100);
		try {
			GameController controller = new GameController();
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("GameUI.fxml"));
			Scene scene = new Scene(root);
			controller.setGame(game);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CounterView view = new CounterView(game);
		game.addObserver(view);
		view.run();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
