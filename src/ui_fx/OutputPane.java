package ui_fx;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OutputPane extends GridPane implements EventHandler<ActionEvent> {
	ArrayList<String> sortedList;
	ListView<String> list;
	SortApp app;

	ScrollPane scrollPane;
	Button stepButton;
	Button finishButton;
	Button newButton;
	VBox buttonBox;

	public OutputPane(SortApp app) {
		super();

		this.app = app;
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);

		list = new ListView<String>();
		list.setPrefSize(300, 200);
		stepButton = new Button("Step");
		finishButton = new Button("Finish");
		newButton = new Button("New");

		buttonBox = new VBox();
		buttonBox.setSpacing(20);
		buttonBox.getChildren().add(stepButton);
		buttonBox.getChildren().add(finishButton);
		buttonBox.getChildren().add(newButton);

		this.add(list, 0, 0, 1, 1);
		this.add(buttonBox, 1, 0);

		stepButton.setOnAction(this);
		finishButton.setOnAction(this);
		newButton.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getSource() == stepButton) {
			this.step();
		} else if (e.getSource() == finishButton) {
			this.finish();
		} else if (e.getSource() == newButton) {
			this.setToNew();
		}
	}

	private void step() {
		if (sortedList.size() >= 2) {
			list.getItems().add(sortedList.remove(0));
			list.getItems().add(sortedList.remove(0));
		}
	}

	private void finish() {
		for (int i = 0; i < sortedList.size(); i++) {
			list.getItems().add(sortedList.get(i));
		}
		sortedList.clear();
	}

	private void setToNew() {
		list.getItems().clear();
		app.setToInput();
	}

	public void setSortedStepList(ArrayList<String> sortedStepList) {
		this.sortedList = sortedStepList;
	}

}
