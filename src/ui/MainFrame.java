package ui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private InputPanel inputPane;
	private OutputPanel outputPane;

	public MainFrame() {
		this.setVisible(true);
		this.setSize(600, 600);
		this.setTitle("Sort");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		inputPane = new InputPanel();
	}

	public void setToInput() {
		this.setContentPane(inputPane);
		this.revalidate();
	}
}
