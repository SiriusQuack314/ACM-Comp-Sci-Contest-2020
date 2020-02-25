import java.util.*;
import java.io.*;

public class DryRun
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new File("dryrun.dat"));
		
		int n = Integer.parseInt(scan.nextLine());
		
		while(n-- > 0)
		{
			System.out.println(scan.nextLine());
		}
	}
}
