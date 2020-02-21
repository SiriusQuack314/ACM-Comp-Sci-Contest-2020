import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CSCat
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner read = new Scanner(new File("cscat.dat"));
		int n = read.nextInt();
		while(n-->0)
		{
			int m = read.nextInt();
			int k = read.nextInt();
			int i = read.nextInt();
			Student[] students = new Student[m];
			for(int j = 0; j<m; j++)
			{
				String department = read.next();
				int diff = read.nextInt();
				int prof = read.nextInt();
				int fin = read.nextInt();
				int current = read.nextInt();
				String major = read.next();
				String name = read.next();
				students[j] = new Student(department, diff, prof, fin, current, major, name);
			}
			
			Arrays.sort(students);
			
			for(int j = 0; j<i && j<m; j++)
			{
				System.out.println(students[j].toString());
			}
			
			System.out.println("-:3");
			
			for(int j = 0; j<i && j<m; j++)
			{
				if(k > 0)
				{
					students[j].catHelp();
					k--;
				}
				System.out.println(students[j].toString());
			}
			System.out.println("=====");
		}
		read.close();
	}
	
	static class Student implements Comparable<Student>
	{
		String department;
		int assignmentDifficulty;
		int studentProficiency;
		int percentGrade;
		int currentAvg;
		String major;
		String name;
		double finalGrade;
		
		public Student(String de, int ad, int sp, int pg, int ca, String m, String n)
		{
			department = de;
			assignmentDifficulty = ad;
			studentProficiency = sp;
			percentGrade = pg;
			currentAvg = ca;
			major = m;
			name = n;
			
			double assignmentGrade = 200.0*(studentProficiency)/assignmentDifficulty;
			finalGrade = (assignmentGrade*percentGrade + currentAvg*(100 - percentGrade))/100.0;
		}
		
		@Override
		public int compareTo(Student o)
		{
			if(!this.major.equals(o.major))
			{
				if(this.major.equals("CS"))
				{
					return -1;
				}
				if(o.major.equals("CS"))
				{
					return 1;
				}
				if(this.major.equals("Math"))
				{
					return -1;
				}
				if(o.major.equals("Math"))
				{
					return 1;
				}
			}
			if(!this.department.equals(o.department))
			{
				if(this.department.equals("CS"))
				{
					return -1;
				}
				if(o.department.equals("CS"))
				{
					return 1;
				}
				if(this.department.equals("Math"))
				{
					return -1;
				}
				if(o.department.equals("Math"))
				{
					return 1;
				}
			}
			if(this.finalGrade != o.finalGrade)
			{
				if(this.finalGrade < o.finalGrade)
				{
					return -1;
				}
				return 1;
			}
			if(this.gradeLetterDifferential() != o.gradeLetterDifferential())
			{
				if(this.gradeLetterDifferential() > o.gradeLetterDifferential())
				{
					return -1;
				}
				return 1;
			}
			return this.name.compareTo(o.name);
		}
		
		public String gradeToLetter(double grade)
		{
			if(grade < 60)
			{
				return "F";
			}
			else if(grade < 70)
			{
				return "D";
			}
			else if(grade < 80)
			{
				return "C";
			}
			else if(grade < 90)
			{
				return "B";
			}
			else
			{
				return "A";
			}
		}

		public int gradeLetterDifferential()
		{
			double grade1 = finalGrade;
			double grade2 = catGrade();
			
			String letter1 = gradeToLetter(grade1);
			String letter2 = gradeToLetter(grade2);
			
			return letter1.compareTo(letter2);
		}
		
		public double catGrade()
		{
			return percentGrade + currentAvg*(100 - percentGrade)/100.0;
		}
		
		public void catHelp()
		{
			finalGrade = catGrade();
		}
		
		public String toString()
		{
			return name+", "+major+": "+gradeToLetter(finalGrade);
		}
	}
}
