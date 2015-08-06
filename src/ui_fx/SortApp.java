package ui_fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SortApp extends Application {
	Scene scene;
	InputPane inputPane;
	OutputPane outputPane;

	@Override
	public void start(Stage stage) throws Exception {
		inputPane = new InputPane(this);
		outputPane = new OutputPane(this);

		stage.setHeight(600);
		stage.setWidth(600);
		stage.centerOnScreen();
		stage.setResizable(false);
		stage.setTitle("Sort");

		scene = new Scene(inputPane);
		stage.setScene(scene);
		stage.show();
	}

	protected void setToInput() {
		scene.setRoot(inputPane);
	}

	protected void setToOutput() {
		scene.setRoot(outputPane);
	}
}
