import java.io.*;
import java.util.*;

public class FeedingBevo
{

	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new File("feedingbevo.dat"));
		
		int t = scan.nextInt();
		
		while(t-- > 0)
		{
			int n = scan.nextInt();
			
			boolean BevoAte = false;
			String date = "";
			scan.nextLine();
			
			for(int i=0;i<n;i++)
			{
				String buttonPush[] = scan.nextLine().split(" ");
				date = buttonPush[0];
				String time[] = buttonPush[1].split(":");
				int hour = Integer.parseInt(time[0]);
				
				if(16 <= hour && hour < 19)
				{
					if(!BevoAte)
					{
						BevoAte = true;
						System.out.println("Feeding Bevo at " + buttonPush[1] + ".");
					}
					else
					{
						System.out.println("Bevo has already eaten!");
					}
				}
				else
				{
					System.out.println("It is not time to feed Bevo!");
				}
				
			}
			
			System.out.print(date + " ");
			if(BevoAte)
			{
				System.out.println("Bevo ate today.");
			}
			else
			{
				System.out.println("Bevo did not eat today.");
			}
			System.out.println("=====");
		}
		
	}

}
