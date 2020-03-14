package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static Stage PRIMARYSTAGE;
	public static Scene MAIN;
	public static Client GAMER;
	public static int HEIGHT = 800;
	public static int WIDTH = 1200;

	@Override
	public void start(Stage primaryStage) throws Exception{

		Parent root = FXMLLoader.load(getClass().getResource("../FXML/sample.fxml"));
		PRIMARYSTAGE = primaryStage;
		MAIN = new Scene(root, WIDTH, HEIGHT);
		primaryStage.setScene(MAIN);
		primaryStage.show();
		System.out.println("Basic Welcome Screen ");

	}

	public static void main(String[] args) {
		launch(args);
	}

}
