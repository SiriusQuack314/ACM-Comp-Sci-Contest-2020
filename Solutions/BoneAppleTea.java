import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class BoneAppleTea {

	public static void main(String[] args) throws Exception {

		int a = 0;

		Scanner in = new Scanner(new FileReader(new File("BoneAppleTea.dat")));
		int t = in.nextInt();
		String[] answers = new String[t];
		String safe = in.nextLine();

		while (a < t) {
			int count = 0;
			int max = 0;
			int key = 0;
			String[] library = { "bone apple tea", "full proof", "bone jaw", "cinnamon", "kidney garden", "human bean",
					"clothes", "angle", "discuss" };
			int[] counters = new int[10];
			String phrase = in.nextLine();

			for (int i = 0; i < library.length; i++) { // check each element in library
				count = 0; // reset count for the element
				for (int j = 0; j < phrase.length(); j++) { // check each char of each element
					if (library[i].contains(phrase.subSequence(j, j + 1))) {
						count++; // if element contains char, increment count
					}
					counters[i] = count;
				} // store the count in a spot in an array that corresponds to the library array
			}

			for (int i = 0; i < counters.length; i++) {
				if (counters[i] > max) {
					max = counters[i]; // find the largest element in the counter array
					key = i; // set a key to the index of the largest element
				} // this key points to the same spot in the library array
			}
			answers[a] = library[key]; // save result
			a++;
		}
		for (int i = 0; i < answers.length; i++) { // print answer
			System.out.println(answers[i]);
		}
	}

}
