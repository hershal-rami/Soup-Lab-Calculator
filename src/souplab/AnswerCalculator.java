package souplab;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class AnswerCalculator {

	public static void main(String[] args) {
		/*
		 * Setup
		 */
		// Tells Java to round to three decimal places
		DecimalFormat numDecimals = new DecimalFormat("#.###");
		DecimalFormat commas = new DecimalFormat("#,###.00");
		numDecimals.setRoundingMode(RoundingMode.CEILING);

		Scanner scan = new Scanner(System.in);
		double circumference, height, radius, predictedVolume, actualVolume, canVolumeInCm, optimizedRadius,
				optimizedHeight, optimizedSurfaceArea, originalSurfaceArea, percentSaved, newCostPerCan, newCost,
				moneySaved;
		boolean running = true;

		/*
		 * Procedure Questions
		 */
		do {
			System.out.println("Procedure Questions:\nQuestion 1:");

			System.out.println("Please enter the measured circumference.");
			circumference = scan.nextDouble();
			scan.nextLine();

			System.out.println("Please enter the measured height.");
			height = scan.nextDouble();
			scan.nextLine();

			radius = circumference / (2.0 * Math.PI);
			System.out.println("Radius: " + numDecimals.format(radius) + " cm");
			System.out.println();

			System.out.println("Question 2:");

			predictedVolume = Math.PI * Math.pow(radius, 2) * height;
			System.out.println("Volume: " + numDecimals.format(predictedVolume) + " cm^3");

			System.out.println("Please enter the volume of the can, in fl oz.");
			actualVolume = scan.nextDouble();
			scan.nextLine();

			canVolumeInCm = 30.0 * actualVolume;
			System.out.println("Can Volume: " + numDecimals.format(canVolumeInCm) + " cm^3");
			System.out.println("Compare this volume to the volume on the can in ounces.");
			System.out.println();

			/*
			 * Analysis Questions
			 */

			System.out.println("Analysis Questions:\nQuestion 1:");
			System.out.println("Production Costs: $14,400,000\n");

			System.out.println("Question 2:");

			optimizedRadius = Math.pow((2.0 * canVolumeInCm) / (4.0 * Math.PI), (1.0 / 3.0));
			System.out.println("Optimal Radius: " + numDecimals.format(optimizedRadius) + " cm");

			optimizedHeight = canVolumeInCm / (Math.PI * Math.pow(optimizedRadius, 2.0));
			System.out.println("Optimal Height: " + numDecimals.format(optimizedHeight) + " cm");
			System.out.println();

			System.out.println("Question 3:");

			optimizedSurfaceArea = (2.0 * Math.PI * Math.pow(optimizedRadius, 2.0))
					+ (2.0 * Math.PI * optimizedRadius * optimizedHeight);
			System.out.println("Optimal Surface Area: " + numDecimals.format(optimizedSurfaceArea) + " cm^2");

			originalSurfaceArea = (2.0 * Math.PI * Math.pow(radius, 2.0)) + (2.0 * Math.PI * radius * height);
			System.out.println("Original Surface Area " + numDecimals.format(originalSurfaceArea) + " cm^2");

			percentSaved = (originalSurfaceArea - optimizedSurfaceArea) / originalSurfaceArea;
			System.out.println("Percent of Metal Saved: " + numDecimals.format((100.0 * percentSaved)) + "%");
			System.out.println();

			System.out.println("Question 4:");

			newCostPerCan = (.06 / originalSurfaceArea) * optimizedSurfaceArea;
			System.out.println("New Cost Per Can: $" + numDecimals.format(newCostPerCan));

			newCost = newCostPerCan * 12.0 * 20000000.0;
			moneySaved = 14400000.0 - newCost;
			System.out.println("New Total Cost: $" + commas.format(newCost));
			System.out.println("Total Money Saved: $" + commas.format(moneySaved));
			System.out.println();
			System.out.println("Enter Q to quit, or press enter to check another set.");
			if (scan.nextLine().toLowerCase().equals("q"))
				running = false;
		} while (running);

		scan.close();
	}
}
