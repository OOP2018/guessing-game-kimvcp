package ui;

import ui.HistoryView;

import javax.print.DocFlavor.URL;

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
			java.net.URL url = getClass().getResource("GameUI.fxml");
			if (url == null) {
				System.out.println("Could not find resource for ");
				return;
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();
			GameController controller = loader.getController();
			controller.setGame(game);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HistoryView view = new HistoryView(game);
		CounterView view2 = new CounterView(game);
		game.addObserver(view);
		game.addObserver(view2);
		view.run();
		view2.run();
	}
	// try {
	// String fxmlfile = "GameUI.fxml";
	// java.net.URL url = getClass().getResource(fxmlfile);
	// // Load the FXML and get reference to the loader
	// FXMLLoader loader = new FXMLLoader(url);
	// // Create scene graph from file (UI)
	// Parent root = loader.load();
	// // Get the controller for the scene
	// GameController controller = loader.getController();
	//
	// // Dependency Injection:
	// // Set the game into the controller
	// controller.setGame(game);
	// // Show the scene
	// Scene scene = new Scene(root);
	// primaryStage.setScene(scene);
	// primaryStage.sizeToScene();
	// primaryStage.setTitle("Let's Guess!");
	// primaryStage.show();
	// } catch (Exception e) {
	// System.out.println("Exception create in scene: " + e.getMessage());
	// e.printStackTrace();
	// }
	// // Add observer that displays game message
	// HistoryView view = new HistoryView(game);
	// CounterView view2 = new CounterView(game);
	// // Register each view to observable
	// game.addObserver(view);
	// game.addObserver(view2);
	// // Display the game message scene
	// view.run();
	// view2.run();
	// }

	public static void main(String[] args) {
		launch(args);
	}
}
