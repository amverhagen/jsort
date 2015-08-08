package ui_fx;

import java.util.ArrayList;

import sorters.Bubble;
import tools.ArrayCreator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SortApp extends Application {
	Scene scene;
	InputPane inputPane;
	OutputPane outputPane;
	int[] unsorted;
	ArrayList<String> sortedStepList;

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
		unsorted = ArrayCreator.getRandomIntArray(inputPane.getSelectedSize());
		sortedStepList = Bubble.getSortedStepList(unsorted);
		for(int i = 0; i < unsorted.length; i++){
			System.out.println();
		}
		outputPane.setSortedStepList(sortedStepList);
		scene.setRoot(outputPane);
	}
}
