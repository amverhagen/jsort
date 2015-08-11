package ui_swing;

import java.util.ArrayList;

import javax.swing.JFrame;

import sorters.Bubble;
import sorters.Merge;
import sorters.Quick;
import sorters.SortType;
import tools.ArrayTools;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private InputPanel inputPane;
	private OutputPanel outputPane;
	private int[] unsorted;
	private ArrayList<String> sortedStepList;

	public MainFrame() {
		super("Sort");
		this.setVisible(true);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		inputPane = new InputPanel(this);
		outputPane = new OutputPanel(this);
	}

	public void setToInput() {
		this.setContentPane(inputPane);
		this.revalidate();
	}

	public void setToOutPut(int arraySize, SortType type) {
		unsorted = ArrayTools.getRandomIntArray(arraySize);
		if (type == SortType.BUBBLE) {
			sortedStepList = Bubble.getSortedStepList(unsorted);
		} else if (type == SortType.MERGE) {
			sortedStepList = Merge.getSortedStepList(unsorted);
		} else if (type == SortType.QUICK) {
			sortedStepList = Quick.getSortedStepList(unsorted);
		}
		outputPane.setSortedStepList(sortedStepList);
		this.setContentPane(outputPane);
		this.revalidate();
	}
}
