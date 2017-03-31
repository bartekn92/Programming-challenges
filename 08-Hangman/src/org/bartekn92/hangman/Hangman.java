package org.bartekn92.hangman;

import java.util.Random;
import java.util.Scanner;


public class Hangman {
	private final int NUMBER_OF_CHANCES = 8;
	private String hiddenWord;
	private String word;

	private void getRandomWord()
	{
		Dictionary dictionary = new Dictionary();
		Random rnd = new Random();
		word = dictionary.getNoun(rnd.nextInt(dictionary.size()));
	}
	
	private void setHiddenWord()
	{
		hiddenWord = word.replaceAll(".", "*");
	}
	
	private void setUpGame()
	{
		getRandomWord();
		setHiddenWord();
	}
	
	public void play()
	{
		setUpGame();
		Scanner scanner = new Scanner(System.in);
		int guessCounter = NUMBER_OF_CHANCES;
		System.out.println("Word now looks like this: " + hiddenWord);
		System.out.println("You have " + guessCounter + " guesses left.");
		
		while(guessCounter > 0) {
			System.out.println("Guess letter");
			String letter = scanner.next();
			while (true) {
				if(letter.length() > 1) {
					System.out.println("You can only guess one letter at a time. Try again: ");
					letter = scanner.next();
				}
				if(letter.length() == 1) break;
			}
			guessCounter--;
			if(!checkLetter(letter.charAt(0)))
				System.out.println("There is no " + letter + " in word.");
			else
			{
				System.out.println("Correct guess.");
				updateHiddenWord(letter.charAt(0));
			}
			if(word.equals(hiddenWord))
			{
				System.out.println("You win!");
				System.out.println("Word was: " + word);
				break;
			}
			System.out.println("Word now looks like this: " + hiddenWord);
			System.out.println("You have " + guessCounter + " guesses left.");
			if (guessCounter == 0) {
				System.out.println("You lose.");
				System.out.println("The word was: " + word);
			}			
		}
		 
		scanner.close();
	}
	
	private boolean checkLetter(char letter)
	{
		if(word.indexOf(letter) == -1)
			return false;
		else
			return true;
	}
	
	private void updateHiddenWord(char letter)
	{
		for(int i=0; i<word.length(); i++)
		{
			if(word.charAt(i) == letter)
			{
				if (i > 0) {
					hiddenWord = hiddenWord.substring(0, i) + letter + hiddenWord.substring(i + 1);
				}
				if(i == 0) {
					hiddenWord = letter + hiddenWord.substring(1);
				}
			}
		}
	}
}
