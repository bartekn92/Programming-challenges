package org.bartekn92.higherlower;

import java.util.Random;
import java.util.Scanner;

public class HigherLower {
	private static final int MAX = 1000;
	private static final int NUMBER_OF_CHANCES = 10;
	
	public static void play()
	{
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(MAX) + 1;
		
		System.out.println("Choose number between 1 and " + MAX + ". You have " + NUMBER_OF_CHANCES + " chances.");
		Scanner scanner = new Scanner(System.in);
		int chosenNumber;
		for(int i=0; i<10; i++)
		{
			chosenNumber = scanner.nextInt();
			if(chosenNumber == randomNumber)
			{
				System.out.println("Success!");
				break;
			}
			else if(chosenNumber < randomNumber)
			{
				System.out.println("Higher");
			}
			else
				System.out.println("Lower");
		}
		scanner.close();
	}
}
