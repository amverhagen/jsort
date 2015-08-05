package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class FxStart extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setHeight(600);
		stage.setWidth(600);
		stage.centerOnScreen();
		stage.setResizable(false);
		stage.setTitle("Sort");
		stage.show();
	}

}
