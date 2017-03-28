package org.bartekn92.randname;

import java.util.Random;

public class RandomPasswordGenerator {
	
	private static final String CHARS  = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_=+-/";

	static public String generate(int minLen, int maxLen)
	{
		if(minLen > maxLen)
			throw new IllegalArgumentException("Min > Max");
		Random random = new Random();
		int len = random.nextInt(maxLen - minLen + 1) + minLen;
		String pass = "";
		for(int i=0; i<len; i++)
		{
			int index = random.nextInt(CHARS.length());
			pass +=   CHARS.charAt(index);
		}
		return pass;
	}
}
