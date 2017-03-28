package org.bartekn92.higherlower;

import java.util.Random;
import java.util.Scanner;

public class HeadsTails {

	public static void play()
	{
		String next = "y";
		Scanner scanner = new Scanner(System.in);
		Random rnd = new Random();	
		while(next.toLowerCase().equals("y"))
		{
			System.out.println("Head or tail? H/T");
			String choice = scanner.next();
			
			int randomNumber = rnd.nextInt(2);
			if(randomNumber == 0)
				System.out.println("Head");
			else
				System.out.println("Tail");
			if((choice.toLowerCase().equals("h") && randomNumber == 0) || (choice.toLowerCase().equals("t") && randomNumber == 1))
				System.out.println("Success!");
			else
				System.out.println("You lose");
			System.out.println("Do you want to continue? Y/N");
			next = scanner.next();
		}		
		scanner.close();
	}
}
