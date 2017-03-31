package org.bartekn92.bmi;

public class BMICalculator {
	public static double calculateBMI(double weight, double height)
	{
		height /= 100.0;
		return (weight/(height * height));
	}
}
