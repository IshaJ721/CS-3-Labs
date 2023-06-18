import java.io.*;
import java.util.*;
public class BoggleSolver
{
	HashSet<String> dictionary = new HashSet<String>();
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
	public BoggleSolver(String dictionaryFileName)
	{
		try {
			Scanner input = new Scanner(new File(dictionaryFileName));
			while(input.hasNext())
			{
				String s = input.nextLine();
				dictionary.add(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable object
	public Iterable<String> getAllValidWords(BoggleBoard board)
	{
		boolean[][] status = new boolean[board.rows()][board.cols()];
		HashSet<String> valids = new HashSet<String>();
		for(int i=0; i<board.rows(); i++)
		{
			for(int j = 0; j<board.cols(); j++)
			{
				getAllValidWords(board, valids, status, i, j, "");
			}
		}
		return valids;
	}
	private void getAllValidWords(BoggleBoard board, HashSet<String> valids, boolean[][] status, int i, int j, String currWord)
	{
		currWord += board.getLetter(i, j);
		if(board.getLetter(i, j)=='Q')
			currWord+='U';
		if(!valids.contains(currWord)&&dictionary.contains(currWord))
			valids.add(currWord);
		status[i][j] = true;
		for(int r = i-1; r<=i+1; r++)
		{
			for(int c = j-1; c<=j+1; c++)
			{
				if(r>=0 && r<board.rows()&&c>=0&&c<board.cols()&&!status[r][c])
					getAllValidWords(board, valids,status, r, c, currWord);
			}
		}
		currWord = "";
		status[i][j] = false;
	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A - Z.)
	public int scoreOf(String word)
	{
		if(dictionary.contains(word))
		{
			int n = word.length();
			switch(n) {
			case 0: 
				return 0;
			case 1: 
				return 0;
			case 2: 
				return 0;
			case 3: 
				return 1;
			case 4: 
				return 1;
			case 5: 
				return 2;
			case 6: 
				return 3;
			case 7: 
				return 5;
			case 8: 
				return 11;
		    default:
		    	return 11;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("WORKING");

		final String PATH   = "./data/";
		BoggleBoard  board  = new BoggleBoard(PATH + "board-q.txt");
		BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");

		int totalPoints = 0;

		for (String s : solver.getAllValidWords(board)) {
			System.out.println(s + ", points = " + solver.scoreOf(s));
			totalPoints += solver.scoreOf(s);
		}

		System.out.println("Score = " + totalPoints); //should print 84

		//new BoggleGame(4, 4);
	}

}
