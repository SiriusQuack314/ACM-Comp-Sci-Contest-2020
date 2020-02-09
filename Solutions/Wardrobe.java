import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class Wardrobe 
{
	// Returns Factorial of N 
    public static BigInteger factorial(int N) 
    {  
        BigInteger f = new BigInteger("1"); 

        for (int i = 2; i <= N; i++) 
            f = f.multiply(BigInteger.valueOf(i)); 
  
        return f; 
    } 

    public static void main(String args[]) throws Exception 
    { 
        Scanner input = new Scanner(new File("wardrobe.dat"));
        while(input.hasNext())
        {
        	 int x = input.nextInt(); 
        	 if(x == 0)
        	 {
        		 System.out.println(1);
        	 }
        	 else
        		 System.out.println(factorial(x));
        }   
    } 
}
