package souplabGUI;

public class AnswerCalculator {

	private double circumference, height, volume;

	/**
	 * Creates and AnswerCalculator object which can be used to calculate answers
	 * for this can's specific measurements
	 * 
	 * @param circumference Circumference of the can
	 * @param height        Height of the can
	 * @param volume        Volume of the can
	 */
	public AnswerCalculator(double circumference, double height, double volume) {
		this.circumference = circumference;
		this.height = height;
		this.volume = volume;

	}

	/**
	 * 
	 * @return Radius of the can calculated using the measured circumference
	 */
	public double getRadius() {
		return circumference / (2.0 * Math.PI);
	}

	/**
	 * 
	 * @return Estimated volume of the can using the measured heigh and calculated radius
	 */
	public double getPredictedVolume() {
		return Math.PI * Math.pow(getRadius(), 2) * height;
	}

	/**
	 * 
	 * @return Can volume converted to the proper units
	 */
	public double getCanVolume() {
		return 30.0 * volume;
	}

	/**
	 * 
	 * @return Optimized radius for the can calculated using the measured volume
	 */
	public double getOptimalRadius() {
		return Math.pow((2.0 * getCanVolume()) / (4.0 * Math.PI), (1.0 / 3.0));
	}

	/**
	 * 
	 * @return Optimized height for the can calculated using the measured volume and optimized radius
	 */
	public double getOptimalHeight() {
		return getCanVolume() / (Math.PI * Math.pow(getOptimalRadius(), 2.0));
	}

	/**
	 * 
	 * @return Optimized surface area for the can calculated using the optimized radius and optimized height
	 */
	public double getOptimalSurfaceArea() {
		return (2.0 * Math.PI * Math.pow(getOptimalRadius(), 2.0))
				+ (2.0 * Math.PI * getOptimalRadius() * getOptimalHeight());
	}

	/**
	 * 
	 * @return Surface area of the can as measured using the radius
	 */
	public double getOriginalSurfaceArea() {
		return (2.0 * Math.PI * Math.pow(getRadius(), 2.0)) + (2.0 * Math.PI * getRadius() * height);
	}

	/**
	 * 
	 * @return Percentage of surface area saved using the optimized surface area
	 */
	public double getPercentSaved() {
		return (getOriginalSurfaceArea() - getOptimalSurfaceArea()) / getOriginalSurfaceArea();
	}

	/**
	 * 
	 * @return Manufacturing cost per can using the optimized surface area
	 */
	public double getNewCostPerCan() {
		return (.06 / getOriginalSurfaceArea()) * getOptimalSurfaceArea();
	}

	/**
	 * 
	 * @return Total cost of all cans using the optimized surface area
	 */
	public double getNewCost() {
		return getNewCostPerCan() * 12.0 * 20000000.0;
	}

	/**
	 * 
	 * @return Amount of money saved by using the optimized can measurements
	 */
	public double getMoneySaved() {
		return 14400000.0 - getNewCost();
	}
}
