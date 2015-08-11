package ui_swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import sorters.SortType;

public class InputPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private MainFrame app;
	private final Integer[] sizes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
			13, 14, 15 };
	private JPanel arraySizePane;
	private JLabel arraySizeLabel;
	private JComboBox<Integer> arraySizeCBox;
	private JPanel actionPanel;
	private ButtonGroup group;
	private JRadioButton quickButton;
	private JRadioButton mergeButton;
	private JRadioButton bubbleButton;
	private JButton sortButton;
	private JLabel warnLabel;

	public InputPanel(MainFrame app) {
		super();
		this.app = app;
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		arraySizePane = new JPanel();
		arraySizeLabel = new JLabel("Array Size");
		arraySizeLabel.setToolTipText("Size of the array you want sorted");
		arraySizeCBox = new JComboBox<Integer>(sizes);

		arraySizePane.add(arraySizeLabel);
		arraySizePane.add(arraySizeCBox);

		actionPanel = new JPanel();
		actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));

		group = new ButtonGroup();

		quickButton = new JRadioButton("Quick");
		group.add(quickButton);
		actionPanel.add(quickButton);

		mergeButton = new JRadioButton("Merge");
		group.add(mergeButton);
		actionPanel.add(mergeButton);

		bubbleButton = new JRadioButton("Bubble");
		group.add(bubbleButton);
		actionPanel.add(bubbleButton);

		sortButton = new JButton("Sort");
		sortButton.addActionListener(this);
		sortButton.setActionCommand("sort");
		actionPanel.add(sortButton);

		warnLabel = new JLabel("");
		actionPanel.add(warnLabel);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 0;
		this.add(arraySizePane, gc);
		gc.gridy = 1;
		this.add(actionPanel, gc);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("sort")) {
			int arraySize = this.getSelectedSize();
			SortType type = this.getSelectedSortType();
			if (getSelectedSortType() != null) {
				app.setToOutPut(arraySize, type);
			} else {
				warnLabel.setText("Must enter a sort type.");
			}
		}
	}

	private int getSelectedSize() {
		int value = (int) arraySizeCBox.getSelectedItem();
		return value;
	}

	private SortType getSelectedSortType() {
		if (mergeButton.isSelected()) {
			return SortType.MERGE;
		} else if (quickButton.isSelected()) {
			return SortType.QUICK;
		} else if (bubbleButton.isSelected()) {
			return SortType.BUBBLE;
		}
		return null;
	}
}
