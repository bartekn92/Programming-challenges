package org.bartekn92.magic8ball;

import java.util.Random;

public class Magic8Ball {
	private String[] answers = new String[] { "It is certain",
			"It is decidedly so", "Without a doubt", "Yes - definitely",
			"You may rely on it", "As I see it, yes", "Most likely",
			"Outlook good", "Signs point to yes", "Yes",
			"Reply hazy, try again", "Ask again later",
			"Better not tell you now", "Cannot predict now",
			"Concentrate and ask again" };
	
	public void getAnswer()
	{
		System.out.println("Magic 8 Ball says: ");
		Random rnd = new Random();
		System.out.println(answers[rnd.nextInt(answers.length)]);
	}
}
