package ui_fx;

import sorters.SortType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class InputPane extends GridPane implements EventHandler<ActionEvent> {
	private final ObservableList<Integer> sizes = FXCollections
			.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
					15);
	private ComboBox<Integer> arraySizeCBox;
	private Text title;
	private Button sortButton;
	private SortApp app;
	private RadioButton mergeButton;
	private RadioButton bubbleButton;
	private RadioButton quickButton;
	private ToggleGroup group;
	private Text warningLabel;

	public InputPane(SortApp app) {
		super();
		this.app = app;
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(20, 20, 20, 20));

		title = new Text("Array Size:");
		this.add(title, 0, 0);

		arraySizeCBox = new ComboBox<Integer>(sizes);
		this.add(arraySizeCBox, 1, 0);

		group = new ToggleGroup();

		mergeButton = new RadioButton("Merge");
		mergeButton.setToggleGroup(group);
		this.add(mergeButton, 0, 2);

		bubbleButton = new RadioButton("Bubble");
		bubbleButton.setToggleGroup(group);
		this.add(bubbleButton, 0, 3);

		quickButton = new RadioButton("Quick");
		quickButton.setToggleGroup(group);
		this.add(quickButton, 0, 4);

		sortButton = new Button("Sort");
		sortButton.setOnAction(this);
		sortButton.setMaxWidth(Double.MAX_VALUE);
		this.add(sortButton, 0, 5, 2, 1);

		warningLabel = new Text("");
		this.add(warningLabel, 0, 6);
	}

	public int getSelectedSize() {
		try {
			return arraySizeCBox.getSelectionModel().getSelectedItem();
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public SortType getSortType() {
		try {
			if (group.getSelectedToggle().equals(mergeButton)) {
				return SortType.MERGE;
			} else if (group.getSelectedToggle().equals(bubbleButton)) {
				return SortType.BUBBLE;
			} else if (group.getSelectedToggle().equals(quickButton)) {
				return SortType.QUICK;
			}
		} catch (NullPointerException e) {
			return null;
		}
		return null;
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getSource() == sortButton) {
			int arraySize = this.getSelectedSize();
			SortType type = this.getSortType();
			if (arraySize == 0) {
				warningLabel.setText("Must enter arraysize.");
			} else if (type == null) {
				warningLabel.setText("Must select a sort type.");
			} else {
				app.setToOutput(arraySize, type);
			}
		}
	}
}
