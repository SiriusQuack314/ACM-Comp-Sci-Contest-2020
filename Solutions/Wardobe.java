import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class Wardobe 
{
	// Returns Factorial of N 
    static BigInteger factorial(int N) 
    {  
        BigInteger f = new BigInteger("1"); 

        for (int i = 2; i <= N; i++) 
            f = f.multiply(BigInteger.valueOf(i)); 
  
        return f; 
    } 

    public static void main(String args[]) throws Exception 
    { 
        Scanner input = new Scanner(new File("input.dat"));
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
