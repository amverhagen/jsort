package ui_swing;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private InputPanel inputPane;
	private OutputPanel outputPane;

	public MainFrame() {
		super("Sort");
		this.setVisible(true);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		inputPane = new InputPanel();
		outputPane = new OutputPanel();
	}

	public void setToInput() {
		this.setContentPane(inputPane);
		this.revalidate();
	}
	
	public void setToOutPut(){
		this.setContentPane(outputPane);
		this.revalidate();
	}
}