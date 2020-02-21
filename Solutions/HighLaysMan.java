import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HighLaysMan
{
	public static char[][] grid;
	
	public static void flood(int x, int y, int life)
	{
		if(life == -1 || x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
		{
			return;
		}
		if(grid[x][y] == '#')
		{
			return;
		}
		grid[x][y] = '#';
		flood(x-1, y, life-1);
		flood(x+1, y, life-1);
		flood(x, y-1, life-1);
		flood(x, y+1, life-1);
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner read = new Scanner(new File("highlaysman.dat"));
		int q = read.nextInt();
		while(q-->0)
		{
			int n = read.nextInt();
			int m = read.nextInt();
			read.nextLine(); //dummy call to parse end-of-line marker
			grid = new char[n][m];
			
			//this are the coordinates of the starting position
			int x = -1;
			int y = -1;
			
			//every bag of chips on the board, saved
			ArrayList<Point> bags = new ArrayList<Point>();
			
			for(int i = 0; i<n; i++)
			{
				String line = read.nextLine().trim();
				for(int j = 0; j<m; j++)
				{
					if(line.charAt(j) == 'S') //always looking for starting position
					{
						x = i;
						y = j;
					}
					if(line.charAt(j) == 'L') //add to bags
					{
						bags.add(new Point(i, j));
					}
					grid[i][j] = line.charAt(j);
				}
			}
			
			//process each bag by converting to barriers
			for(Point p : bags)
			{
				int r = p.x;
				int c = p.y;
				flood(r, c, 2); //the number 2 is used because you cannot travel within two cells of a bag
			}
			
			flood(x, y, 9999); //floodfill, using an arbitrarily high life counter
			
			//if the grid still contains the character 'E', the answer is no, because the flood didn't reach it
			boolean reach = true;
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<m; j++)
				{
					if(grid[i][j] == 'E')
					{
						reach = false;
					}
				}
			}
			System.out.println(reach ? "YES" : "NO");
		}
		read.close();
	}
}