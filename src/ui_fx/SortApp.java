package ui_fx;

import java.util.ArrayList;

import sorters.Bubble;
import sorters.Merge;
import sorters.Quick;
import sorters.SortType;
import tools.ArrayTools;
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

	protected void setToOutput(int arraySize, SortType type) {
		unsorted = ArrayTools.getRandomIntArray(arraySize);
		if (type == SortType.BUBBLE) {
			sortedStepList = Bubble.getSortedStepList(unsorted);
		} else if (type == SortType.MERGE) {
			sortedStepList = Merge.getSortedStepList(unsorted);
		} else if (type == SortType.QUICK) {
			sortedStepList = Quick.getSortedStepList(unsorted);
		}
		outputPane.setSortedStepList(sortedStepList);
		scene.setRoot(outputPane);
	}
}
