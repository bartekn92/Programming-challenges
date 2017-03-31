package org.bartekn92.collatz;

public class CollatzConjecture {
	public static void solve(int x)
	{
		System.out.print(x + " ");
		if(x == 1) 
			return; 
		else if(x % 2 == 0)
			solve(x/2);
		else
			solve(3 * x + 1);
	}
}
