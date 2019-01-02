package souplabGUI;

public class AnswerCalculator {

	private double circumference, height, volume;
	public AnswerCalculator(double circumference, double height, double volume) {
		this.circumference = circumference;
		this.height = height;
		this.volume = volume;
		
	}
	
	public double getRadius() {
		return circumference / (2.0 * Math.PI);
	}
	
	public double getPredictedVolume() {
		return Math.PI * Math.pow(getRadius(), 2) * height;
	}
	
	public double getCanVolume() {
		return 30.0 * volume;
	}
	
	public double getOptimalRadius() {
		return Math.pow((2.0 * getCanVolume()) / (4.0 * Math.PI), (1.0 / 3.0));
	}
	
	public double getOptimalHeight() {
		return getCanVolume() / (Math.PI * Math.pow(getOptimalRadius(), 2.0));
	}
	
	public double getOptimalSurfaceArea() {
		return (2.0 * Math.PI * Math.pow(getOptimalRadius(), 2.0))
				+ (2.0 * Math.PI * getOptimalRadius() * getOptimalHeight());
	}
	
	public double getOriginalSurfaceArea() {
		return (2.0 * Math.PI * Math.pow(getRadius(), 2.0)) + (2.0 * Math.PI * getRadius() * height);
	}
	
	public double getPercentSaved() {
		return (getOriginalSurfaceArea() - getOptimalSurfaceArea()) / getOriginalSurfaceArea();
	}
	
	public double getNewCostPerCan() {
		return (.06 / getOriginalSurfaceArea()) * getOptimalSurfaceArea();
	}
	
	public double getNewCost() {
		return getNewCostPerCan() * 12.0 * 20000000.0;
	}
	
	public double getMoneySaved() {
		return 14400000.0 - getNewCost();
	}
}
