import java.io.*;
import java.util.*;

public class Dinner
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new File("dinner.dat"));
		
		int t = scan.nextInt();
		
		while(t-- > 0)
		{
			int n = scan.nextInt();
			int m = n;
			
			int powerOf2 = 0;
			
			while(m>1)
			{
				m /= 2;
				powerOf2++;
			}
			
			int leftover = n - (int) Math.pow(2, powerOf2);
			
			int position = leftover * 2 + 1;
			
			System.out.println("Person " + position);
		}
		
	}
}
