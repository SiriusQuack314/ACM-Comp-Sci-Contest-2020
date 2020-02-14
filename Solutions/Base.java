import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Base
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner read = new Scanner(new File("base.dat"));
		int t = read.nextInt();
		while(t-->0)
		{
			int x = read.nextInt();
			int max = 0;
			int base = 36;
			
			//Check each base, starting with the largest and working down to seven;
			//All lower bases do not contain '6'
			for(int b = 36; b>=7; b--)
			{
				String s = Integer.toString(x, b);
				int numOfSixes = 0;
				
				for(int i = 0; i<s.length(); i++)
				{
					if(s.charAt(i) == '6')
					{
						numOfSixes++;
					}
				}
				
				//A much shorter method that calculates the same as the above for loop, but is more complex
				/*
				 * numOfSixes = s.split("6", -1).length - 1;
				 */
				
				if(numOfSixes > max)
				{
					max = numOfSixes;
					base = b;
				}
			}
			System.out.println(base);
		}
		read.close();
	}
}