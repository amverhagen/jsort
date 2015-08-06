package ui_fx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OutputPane extends GridPane implements EventHandler<ActionEvent> {
	ListView<String> list;
	SortApp app;
	Label title;
	Label arrayLabel;
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

		title = new Label("Init Array:");
		arrayLabel = new Label("[]");
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

		this.add(title, 0, 0);
		this.add(arrayLabel, 0, 1);
		this.add(list, 0, 2, 1, 1);
		this.add(buttonBox, 1, 2);

		stepButton.setOnAction(this);
		finishButton.setOnAction(this);
		newButton.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getSource() == stepButton) {
			step();
		} else if (e.getSource() == finishButton) {
			this.finish();
		} else if (e.getSource() == newButton) {
			app.setToInput();
		}
	}

	private void step() {

	}

	private void finish() {

	}

}
