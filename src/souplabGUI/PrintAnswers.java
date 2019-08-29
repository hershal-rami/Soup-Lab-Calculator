package souplabGUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrintAnswers {

	private final JFrame frame;

	public PrintAnswers(double circumference, double height, double volume) {
		frame = new JFrame("Answer Key");

		JLabel radius, predictedVolume, canVolume, optimalRadius, optimalHeight, optimalSurfaceArea,
				originalSurfaceArea, percentSaved, newCostPerCan, newCost, moneySaved;

		JLabel productionCost = new JLabel("Production Costs: $14,400,400");

		AnswerCalculator answers = new AnswerCalculator(circumference, height, volume);

		frame.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(10, 10, 10, 10);

		DecimalFormat numDecimals = new DecimalFormat("#.###");
		DecimalFormat commas = new DecimalFormat("#,###.00");
		numDecimals.setRoundingMode(RoundingMode.CEILING);

		constraint.gridy = 0;
		radius = new JLabel("Radius: " + numDecimals.format(answers.getRadius()) + " cm");
		frame.add(radius, constraint);

		constraint.gridy = 1;
		predictedVolume = new JLabel(
				"Calculated Volume: " + numDecimals.format(answers.getPredictedVolume()) + " cm^3");
		frame.add(predictedVolume, constraint);

		constraint.gridy = 2;
		canVolume = new JLabel("Can Volume: " + numDecimals.format(answers.getCanVolume()) + " cm^3");
		frame.add(canVolume, constraint);

		constraint.gridy = 3;
		frame.add(productionCost, constraint);

		constraint.gridy = 4;
		optimalRadius = new JLabel("Optimal Radius: " + numDecimals.format(answers.getOptimalRadius()) + " cm");
		frame.add(optimalRadius, constraint);

		constraint.gridy = 5;
		optimalHeight = new JLabel("Optimal Height: " + numDecimals.format(answers.getOptimalHeight()) + " cm");
		frame.add(optimalHeight, constraint);

		constraint.gridy = 6;
		optimalSurfaceArea = new JLabel(
				"Optimal Surface Area: " + numDecimals.format(answers.getOptimalSurfaceArea()) + " cm^2");
		frame.add(optimalSurfaceArea, constraint);

		constraint.gridy = 7;
		originalSurfaceArea = new JLabel(
				"Original Surface Area: " + numDecimals.format(answers.getOriginalSurfaceArea()) + " cm^2");
		frame.add(originalSurfaceArea, constraint);

		constraint.gridy = 8;
		percentSaved = new JLabel(
				"Percent of Metal Saved: " + numDecimals.format(100.0 * answers.getPercentSaved()) + "%");
		frame.add(percentSaved, constraint);

		constraint.gridy = 9;
		newCostPerCan = new JLabel("New Cost Per Can: $" + commas.format(answers.getNewCostPerCan()));
		frame.add(newCostPerCan, constraint);

		constraint.gridy = 10;
		newCost = new JLabel("New Total Cost: $" + commas.format(answers.getNewCost()));
		frame.add(newCost, constraint);

		constraint.gridy = 11;
		moneySaved = new JLabel("Total Money Saved: $" + commas.format(answers.getMoneySaved()));
		frame.add(moneySaved, constraint);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public final JFrame getMainFrame() {
		return frame;
	}
}
