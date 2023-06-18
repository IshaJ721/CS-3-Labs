import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("input.txt"));
		while (input.hasNext()) {
			{
			String start = input.next();
			String end = input.next();
			WordLadder wordladder = new WordLadder(start, end);
			wordladder.start();
			}
		}
	}

}
