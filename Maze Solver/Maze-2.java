import java.io.*;
import java.util.*;

public class Maze {
	Square[][] squares;
	Square start, exit;
	public Maze()
	{
		
	}
	public boolean loadMaze(String filename)
	{
		try
		{
			Scanner scan  = new Scanner(new File(filename));
			squares = new Square[scan.nextInt()][scan.nextInt()];
			for(int i =0; i<squares.length; i++)
			{
				for(int j = 0; j<squares[0].length;j++)
				{
				int x = scan.nextInt();
				if(x==0)
				{
					Square s = new Square(i, j, 0);
					squares[i][j] = s;
				}
				if(x==1)
				{
					Square s = new Square(i, j, 1);
					squares[i][j] = s;
				}
				if(x==2)
				{
					Square s = new Square(i, j, 2);
					squares[i][j] = s;
					start = s;
				}
				if(x==3)
				{
					Square s = new Square(i, j, 3);
					squares[i][j] = s;
					exit = s;
				}
			}
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Incorrect file name");
			e.printStackTrace();
			return false;
		}
			return true;
	}
	public List<Square> getNeighbors(Square s)
	{
		List<Square> list = new ArrayList<Square>();
		if(s.getRow()+1<squares.length&&s.getCol()<squares[0].length&&s.getRow()+1>=0&&s.getCol()>=0)
			list.add(squares[s.getRow()+1][s.getCol()]);
		if(s.getRow()<squares.length&&s.getCol()+1<squares[0].length&&s.getRow()>=0&&s.getCol()+1>=0)
			list.add(squares[s.getRow()][s.getCol()+1]);
		if(s.getRow()-1<squares.length&&s.getCol()<squares[0].length&&s.getRow()-1>=0&&s.getCol()>=0)
			list.add(squares[s.getRow()-1][s.getCol()]);
		if(s.getRow()<squares.length&&s.getCol()-1<squares[0].length&&s.getRow()>=0&&s.getCol()-1>=0)
			list.add(squares[s.getRow()][s.getCol()-1]);
		return list;
	}
	public Square getStart()
	{
		return start;
	}
	public Square getExit()
	{
		return exit;
	}
	public void reset()
	{
		for(int i = 0; i<squares.length;i++)
		{
			for(int j = 0; j<squares[0].length; j++)
			{
				squares[i][j].setStatus(Square.UNKNOWN);
				squares[i][j].previous = null;
			}
		}
	}
	public String toString()
	{
		String stringRep = "";
		for(int i = 0; i<squares.length;i++)
		{
			for(int j = 0; j<squares[0].length; j++)
			{
				stringRep += squares[i][j].toString()+" ";
			}
			stringRep+="\n";
		}
		return stringRep;
	}

}
