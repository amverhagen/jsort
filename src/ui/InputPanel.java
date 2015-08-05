package ui;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final Integer[] sizes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
			13, 14, 15 };
	private JPanel arraySizePane;
	private JLabel arraySizeLabel;
	private JComboBox<Integer> arraySizeCBox;

	public InputPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		arraySizePane = new JPanel();
		arraySizeLabel = new JLabel("Array Size");
		arraySizeCBox = new JComboBox<Integer>(sizes);

		arraySizePane.add(arraySizeLabel);
		arraySizePane.add(arraySizeCBox);

		this.add(arraySizePane);
	}
}
