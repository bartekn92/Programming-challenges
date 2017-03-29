package org.bartekn92.playfair;

public class Playfair {

	private String keyWord = new String();
	private String key = new String();
	private char matrixArr[][]= new char[5][5];

	public void setKeyWord(String k)
	{
		if(k.length() == 0)
			throw new IllegalArgumentException("Key cannot be empty!");
		k = k.toUpperCase().replaceAll("[^A-Z]", "");
		keyWord += k.charAt(0);
	
		for(int i=1; i<k.length(); i++)
		{
			if(!keyWord.contains(Character.toString(k.charAt(i))))
				keyWord += k.charAt(i);
		}
	}
	
	public void generateKey()
	{
		char currentChar;
		key = keyWord;
		for(int i=0 ; i<26 ; i++)
		{
			currentChar=(char)(i+65);		
			if(currentChar=='J')
				continue;		
			if(!keyWord.contains(Character.toString(currentChar)))
				key += currentChar;
		}
		fillMatrix();
	} 
	
	private void fillMatrix ()
	{
		int counter=0;	
		for (int i=0 ; i<5 ;i++)
		{
			for (int j=0 ; j<5 ; j++)
			{
				matrixArr[i][j]=key.charAt(counter);			
				counter++;
			}
		}
	}
		
	private String formatMessage(String message)
	{
		message = message.toUpperCase().replaceAll("[^A-Z]", "");
		message = message.replace("J", "I");
		
		String resultText = new String();
		int len = message.length();
		for (int i = 0; i < len; i = i + 2)
		{ 
			resultText += message.charAt(i);
			if( i + 1 < len )
			{
			    if( message.charAt(i) == message.charAt(i+1) ) 
			    	resultText += 'X';
			    resultText += message.charAt(i+1);
			}
		}
		return resultText;
	}
	
	private String[] divide2Pairs(String message)
    {
        String original = formatMessage(message);
        int size = original.length();
        if (size % 2 != 0)
        {
            size++;
            original = original + 'X';
        }
        String pairs[] = new String[size / 2];
        int counter = 0;
        for (int i = 0; i < size / 2; i++)
        {
        	pairs[i] = original.substring(counter, counter + 2);
            counter = counter + 2;
        }
        return pairs;
    }
	
	private int[] getDimensions(char letter)
    {
        int[] key = new int[2];
        if (letter == 'J')
        	letter = 'I';
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (matrixArr[i][j] == letter)
                {
                    key[0] = i;
                    key[1] = j;
                    break;
                }
            }
        }
        return key;
    }
		
	public String encrypt(String Source)
	{ 

		String pairs[] = divide2Pairs(Source);
		String encipheredText = new String();
	
		char first;
		char second;
	
		int firstPosition[] = new int[2];
		int secondPosition[] = new int[2];
	
		for (int i=0 ; i< pairs.length ;i++ )
		{
			first = pairs[i].charAt(0);
			second = pairs[i].charAt(1);

			firstPosition = getDimensions(first);
			secondPosition = getDimensions(second);

			//the same row
			if(firstPosition[0] == secondPosition[0])
			{
				if (firstPosition[1] < 4)
					firstPosition[1]++;
				else
					firstPosition[1] = 0;
			
				if(secondPosition[1] < 4)
					secondPosition[1]++;
				else
					secondPosition[1] = 0;
			}
		
			//the same column
			else if (firstPosition[1] == secondPosition[1])
			{
				if (firstPosition[0] < 4)
					firstPosition[0]++;
				else
					firstPosition[0] = 0;
			
				if(secondPosition[0] < 4)
					secondPosition[0]++;
				else
					secondPosition[0] = 0;
			}
			else
			{
				int temp = firstPosition[1];
				firstPosition[1] = secondPosition[1];
				secondPosition[1] = temp;
			}
		
			encipheredText = encipheredText + matrixArr[firstPosition[0]][firstPosition[1]] + matrixArr[secondPosition[0]][secondPosition[1]];
		}
		return encipheredText;
	} 
	
	public String decrypt(String message)
	{
		String decryptedText = new String();
		String pairs[] = divide2Pairs(message);	
		char first;
		char second;
	
		int firstPosition[]=new int[2];
		int secondPosition[]=new int[2];
	
		for (int i=0 ; i< pairs.length ;i++ )
		{
			first = pairs[i].charAt(0);
			second = pairs[i].charAt(1);
	
			firstPosition = getDimensions(first);
			secondPosition = getDimensions(second);
		

			if(firstPosition[0]==secondPosition[0])
			{
				if (firstPosition[1] > 0)
					firstPosition[1]--;
				else
					firstPosition[1] = 4;
			
				if(secondPosition[1] > 0)
					secondPosition[1]--;
				else
					secondPosition[1] = 4;
			}
		
			else if (firstPosition[1] == secondPosition[1]) //same column
			{
				if (firstPosition[0] > 0)
					firstPosition[0]--;
				else
					firstPosition[0] = 4;
			
				if(secondPosition[0] > 0)
					secondPosition[0]--;
				else
					secondPosition[0] = 4;
			}
			else
			{
				int temp = firstPosition[1];
				firstPosition[1] = secondPosition[1];
				secondPosition[1] = temp;
			}
			decryptedText = decryptedText + matrixArr[firstPosition[0]][firstPosition[1]] + matrixArr[secondPosition[0]][secondPosition[1]];
		}
		return decryptedText;
	}
}
