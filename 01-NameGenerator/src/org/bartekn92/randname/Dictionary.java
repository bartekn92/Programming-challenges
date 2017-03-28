package org.bartekn92.randname;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Dictionary {
	private List<String> syllables = new ArrayList<String>();
	
	public Dictionary()
	{
		try
		{
			loadDictionary("syllables.txt");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			throw new Error(e);
		}
	}
	
	public int size()
	{
		return syllables.size();
	}
	
	public String getSyllable(int n)
	{
		return syllables.get(n);
	}
	
	private void loadDictionary(String path) throws IOException
	{
		Scanner reader = new Scanner(new File(path));
		
		while(reader.hasNextLine())
		{
			syllables.add(reader.nextLine());
		}
		reader.close();
	}

}
