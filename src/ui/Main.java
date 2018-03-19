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

	public static void main(String[] args) {
		launch(args);
	}
}
