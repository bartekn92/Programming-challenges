package org.bartekn92.tempconverter;

public class TemperatureConventer {

	public static double convertFtoC(double F)
	{
		return (5.0/9.0) * (F-32);
	}
	
	public static double convertCtoF(double C)
	{
		return C*(9.0/5.0) + 32;
	}
}
