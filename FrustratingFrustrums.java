import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrustratingFrustrumsNick 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		//Both of these Methods are suitable for solving this problem, choose your preference
		methodOne();
		//methodTwo();
	}
	
	public static void methodOne() throws FileNotFoundException
	{
		Scanner kb = new Scanner(new File("frustratingFrustrums.txt"));
		double r1 = kb.nextDouble();
		double r2 = kb.nextDouble();
		double h = kb.nextDouble();
		double h1 = kb.nextDouble();
		double h2 = kb.nextDouble();
		double m = (r2-r1)/h;
		double r3 = r2-m*h1;
		double r4 = r3-m*h2;
		System.out.println(1.0/3*Math.PI*h2*(r3*r3+r4*r4+r4*r3));
		kb.close();
	}
	
	public static void methodTwo() throws FileNotFoundException
	{
		Scanner inputFile = new Scanner(new File("frustratingFrustrums.txt"));
		double r1 = inputFile.nextDouble();
		double R = inputFile.nextDouble();
		double hTotal = inputFile.nextDouble();
		double hTriplePrime = inputFile.nextDouble();
		double hPrime = inputFile.nextDouble();
		
		//Calculates the angle of the frustrum
		double theta = Math.atan(hTotal/(R-r1));
		//calculates the remaining height other than the two given
		double hDoublePrime = hTotal - h1 - h2;
		//Calculates the radius of the 2nd circle from the bottom
		double RPrime = (h3+h2)/Math.tan(theta)+r1;
		//Calculates the radius of the 3rd circle from the bottom
		double rPrime = h3/Math.tan(theta)+r1;
		
		//Output
		System.out.println(1.0/3*Math.PI*hPrime*(Math.pow(RPrime,2)+Math.pow(rPrime, 2)+rPrime*RPrime));
		
		//Scanner Closing Statement
		inputFile.close();

	}

}
