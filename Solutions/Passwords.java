import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Passwords
{
	public static boolean capital(String s)
	{
		return s.matches(".*[A-Z].*");
	}
	
	public static boolean lowercase(String s)
	{
		return s.matches(".*[a-z].*");
	}
	
	public static boolean number(String s)
	{
		return s.matches(".*[0-9].*");
	}
	
	public static boolean consecutiveFollow(String s, String s1, String s2)
	{
		return s.contains(s1.concat(s2));
	}
	
	public static boolean subsequentFollow(String s, String s1, String s2)
	{
		s1 = s1.replace("*", "\\*");
		s2 = s2.replace("*", "\\*");
		return s.matches(".*"+s1+".*"+s2+".*");
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner read = new Scanner(new File("passwords.dat"));
		int n = read.nextInt();
		while(n-->0)
		{
			int k = read.nextInt();
			
			//these are set to null so that they will be skipped during evaluation if they are not used
			Boolean cap = null;
			Boolean low = null;
			Boolean num = null;
			HashMap<String, Boolean> special = new HashMap<String, Boolean>();
			int lengthNum = -1;
			String lengthStyle = "";
			HashMap<String[], Boolean> consecutive = new HashMap<String[], Boolean>();
			HashMap<String[], Boolean> subsequent = new HashMap<String[], Boolean>();
			for(int i = 0; i<k; i++)
			{
				String s = read.next();
				switch(s)
				{
				case "Capital":
				{
					cap = read.nextBoolean();
				}
				break;
				case "Lowercase":
				{
					low = read.nextBoolean();
				}
				break;
				case "Number":
				{
					num = read.nextBoolean();
				}
				break;
				case "Special":
				{
					String ch = read.next();
					boolean b = read.nextBoolean();
					special.put(ch, b);
				}
				break;
				case "Length":
				{
					lengthNum = read.nextInt();
					lengthStyle = read.next();
				}
				break;
				case "Follow":
				{
					String s1 = read.next();
					String s2 = read.next();
					boolean b1 = read.nextBoolean();
					boolean b2 = read.nextBoolean();
					if(b1)
					{
						consecutive.put(new String[] {s2, s1}, b2);
					}
					else
					{
						subsequent.put(new String[] {s2, s1}, b2);
					}
				}
				break;
				}
			}
			int m = read.nextInt();
			for(int i = 0; i<m; i++)
			{
				String s = read.next();
				int correct = 0;
				int total = 0;
				
				//check each existing filter for correctness
				if(cap != null)
				{
					total++;
					if(cap == capital(s))
					{
						correct++;
					}
				}
				
				if(low != null)
				{
					total++;
					if(low == lowercase(s))
					{
						correct++;
					}
				}
				
				if(num != null)
				{
					total++;
					if(num == number(s))
					{
						correct++;
					}
				}
				
				for(String spec : special.keySet())
				{
					total++;
					if(s.contains(spec) == special.get(spec))
					{
						correct++;
					}
				}
				
				if(lengthNum != -1)
				{
					total++;
					switch(lengthStyle)
					{
					case "<": if(s.length() <= lengthNum) correct++; break;
					case ">": if(s.length() >= lengthNum) correct++; break;
					case "=": if(s.length() == lengthNum) correct++; break;
					}
				}
				
				for(String[] cons : consecutive.keySet())
				{
					total++;
					String s1 = cons[0];
					String s2 = cons[1];
					boolean b = consecutive.get(cons);
					if(b == consecutiveFollow(s, s1, s2))
					{
						correct++;
					}
				}
				
				for(String[] sub : subsequent.keySet())
				{
					total++;
					String s1 = sub[0];
					String s2 = sub[1];
					boolean b = subsequent.get(sub);
					if(b == subsequentFollow(s, s1, s2))
					{
						correct++;
					}
				}
				
				double strength = 100.0*correct/total;
				if(strength == 0)
				{
					System.out.println(s+": Abysmal");
				}
				else if(strength < 25)
				{
					System.out.println(s+": Terrible");
				}
				else if(strength < 50)
				{
					System.out.println(s+": Weak");
				}
				else if(strength < 75)
				{
					System.out.println(s+": Moderate");
				}
				else if(strength < 100)
				{
					System.out.println(s+": Strong");
				}
				else
				{
					System.out.println(s+": Excellent");
				}
			}
			System.out.println("=====");
		}
		read.close();
	}
}