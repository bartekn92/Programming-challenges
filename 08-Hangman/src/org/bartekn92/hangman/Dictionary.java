package org.bartekn92.hangman;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Dictionary {
	private List<String> nouns = new ArrayList<String>();
	
	public Dictionary()
	{
		try
		{
			loadDictionary("nouns.txt");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			throw new Error(e);
		}
	}
	
	public int size()
	{
		return nouns.size();
	}
	
	public String getNoun(int n)
	{
		return nouns.get(n);
	}
	
	private void loadDictionary(String path) throws IOException
	{
		Scanner reader = new Scanner(new File(path));
		
		while(reader.hasNextLine())
		{
			nouns.add(reader.nextLine());
		}
		reader.close();
	}

}
