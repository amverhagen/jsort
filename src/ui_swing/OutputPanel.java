package ui_swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OutputPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private MainFrame app;
	private GridBagConstraints gc;
	private ArrayList<String> sortedStepList;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private JPanel buttonPanel;
	private JButton stepButton;
	private JButton finishButton;
	private JButton newButton;

	public OutputPanel(MainFrame app) {
		super();
		this.app = app;
		this.setLayout(new GridBagLayout());
		gc = new GridBagConstraints();

		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		gc.gridx = 0;
		gc.gridy = 0;
		JScrollPane listScroller = new JScrollPane(list);
		this.add(listScroller, gc);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		stepButton = new JButton("Step");
		stepButton.addActionListener(this);
		stepButton.setActionCommand("step");
		buttonPanel.add(stepButton);

		finishButton = new JButton("Finish");
		finishButton.addActionListener(this);
		finishButton.setActionCommand("finish");
		buttonPanel.add(finishButton);

		newButton = new JButton("New");
		newButton.addActionListener(this);
		newButton.setActionCommand("new");
		buttonPanel.add(newButton);

		gc.gridx = 1;
		this.add(buttonPanel, gc);
	}

	public void setSortedStepList(ArrayList<String> sortedStepList) {
		this.sortedStepList = sortedStepList;
		listModel.clear();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("step")) {
			this.step();
		} else if (event.getActionCommand().equals("finish")) {
			this.finish();
		} else if (event.getActionCommand().equals("new")) {
			this.reset();
		}
	}

	private void step() {
		if (sortedStepList.size() > 0) {
			listModel.addElement(sortedStepList.remove(0));
		}
	}

	private void finish() {
		for (int i = 0; i < sortedStepList.size(); i++) {
			listModel.addElement(sortedStepList.get(i));
		}
		sortedStepList.clear();
	}

	private void reset() {
		app.setToInput();
	}
}
