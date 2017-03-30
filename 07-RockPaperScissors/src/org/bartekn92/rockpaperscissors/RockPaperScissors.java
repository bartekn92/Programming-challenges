package org.bartekn92.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {

	private boolean playAgain(Scanner scanner) {
        System.out.println("Play again? Y/N?");
        if(scanner.next().toLowerCase().equals("y"))
        	return true;
        else
        	return false;
    }
	
	public void play()
	{
		Scanner scanner = new Scanner(System.in);
		Random rnd = new Random();	
		do
		{
			System.out.println("Enter your choice ([R]ock [P]aper [S]cissors)");
			String choice = scanner.next();
			
			int userChoice;
			if(choice.toLowerCase().equals("r"))
				userChoice = Choice.ROCK.ordinal();
			else if(choice.toLowerCase().equals("p"))
				userChoice = Choice.PAPER.ordinal();
			else if(choice.toLowerCase().equals("s"))
				userChoice = Choice.SCISSORS.ordinal();
			else
			{	userChoice = Choice.values()[rnd.nextInt(3)].ordinal();
				System.out.println("Wrong input. You got " + Choice.values()[userChoice]);
			}
			
			int computerChoice = rnd.nextInt(3);
			
			System.out.println(Choice.values()[userChoice] + " vs " + Choice.values()[computerChoice]);
			System.out.println(checkWinner(userChoice, computerChoice));
		} while(playAgain(scanner));
		scanner.close();
	}
	
	private GameEnding checkWinner(int userChoice, int computerChoice)
	{
		if(userChoice == 0 && computerChoice == 1 || userChoice == 1 && computerChoice == 2 || userChoice == 2 && computerChoice == 0)
			return GameEnding.CPU_WINS;
		else if(userChoice == 0 && computerChoice == 2 || userChoice == 1 && computerChoice == 0 || userChoice == 2 && computerChoice == 1)
			return GameEnding.USER_WINS;
		return GameEnding.TIE;
	}
}
