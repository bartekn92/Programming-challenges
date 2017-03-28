package org.bartekn92.randname;

import java.util.Random;

public class RandomNameGenerator {

	static public String generate()
	{
		Random random = new Random();
		int numberOfSyllables = random.nextInt(5) + 2;
		StringBuilder name = new StringBuilder();
		Dictionary dictionary = new Dictionary();
		for(int i=0; i <numberOfSyllables; i++)
			name.append(dictionary.getSyllable(random.nextInt(dictionary.size())));
		return name.toString();
	}
}
