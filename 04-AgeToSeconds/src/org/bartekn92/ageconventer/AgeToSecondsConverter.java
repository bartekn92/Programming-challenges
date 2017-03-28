package org.bartekn92.ageconventer;

import java.util.GregorianCalendar;

public class AgeToSecondsConverter {

	public static long getAgeInSeconds(int year, int month, int dayOfMonth)
	{
		GregorianCalendar startDate = new GregorianCalendar(year, month - 1, dayOfMonth);
		return (new GregorianCalendar().getTimeInMillis() - startDate.getTimeInMillis())/1000;
	}
}
