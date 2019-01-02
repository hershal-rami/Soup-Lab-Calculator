package souplabGUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GetValues {
	private double circumference, height, volume;
	private ArrayList<PrintAnswers> openWindows = new ArrayList<PrintAnswers>();
	private boolean answerWindowOpen = false;
	
	public GetValues() {
		JFrame frame = new JFrame("Soup Lab Grading Calculator");

		JLabel circumLabel = new JLabel("Measured circumference");
		JLabel heightLabel = new JLabel("Measured height");
		JLabel volumeLabel = new JLabel("Volume of the can, in fl oz");
		JLabel error = new JLabel("Please enter a number for all boxes.");

		JTextField circumInput = new JTextField(10);
		JTextField heightInput = new JTextField(10);
		JTextField volumeInput = new JTextField(10);

		JButton answerButton = new JButton("Get Answers");
		JButton resetButton = new JButton("Reset");

		frame.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(10, 10, 10, 10);
		constraint.gridx = 0;
		constraint.gridy = 0;
		frame.add(circumLabel, constraint);

		constraint.gridy = 1;
		frame.add(heightLabel, constraint);

		constraint.gridy = 2;
		frame.add(volumeLabel, constraint);

		constraint.gridx = 1;
		constraint.gridy = 0;
		frame.add(circumInput, constraint);

		constraint.gridy = 1;
		frame.add(heightInput, constraint);

		constraint.gridy = 2;
		frame.add(volumeInput, constraint);

		constraint.gridx = 0;
		constraint.gridy = 4;
		frame.add(answerButton, constraint);

		constraint.gridx = 1;
		constraint.gridy = 4;
		frame.add(resetButton, constraint);

		constraint.gridx = 0;
		constraint.gridy = 5;
		frame.add(error, constraint);
		error.setVisible(false);
		frame.pack();

		answerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (circumInput.getText().equals("") || heightInput.getText().equals("")
						|| volumeInput.getText().equals("")) {
					error.setVisible(true);
					frame.pack();
					return;
				} else {
					error.setVisible(false);
					frame.pack();
				}
				circumference = Double.parseDouble(circumInput.getText());
				height = Double.parseDouble(heightInput.getText());
				volume = Double.parseDouble(volumeInput.getText());
				openWindows.add(new PrintAnswers(circumference, height, volume));
				answerWindowOpen = true;
			}

		});

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				circumInput.setText("");
				heightInput.setText("");
				volumeInput.setText("");

				if(answerWindowOpen) {
					closeAnswerWindows();
					answerWindowOpen = false;
				}

			}

		});

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				int reply = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?", "Exit",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (reply == JOptionPane.YES_OPTION) {
					frame.dispose();
					closeAnswerWindows();
				} else {
					return;
				}
			}
		});

		frame.pack();
		System.out.println(frame.getSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new GetValues();
	}
	
	public void closeAnswerWindows() {
		for(PrintAnswers window : openWindows) {
			window.getMainFrame().dispose();
		}
	}
}