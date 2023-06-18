import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordLadder {
    private Queue<Stack> queue = new LinkedList<Stack>();
    private String start, end;
    private Stack<String> stack = new Stack<String>();
    
    public WordLadder(String start, String end)
    {
    	this.start = start.toUpperCase();
    	this.end = end.toUpperCase();
    }


	public String start() throws FileNotFoundException {
		Scanner dict = new Scanner(new File("dictionary.txt"));
		ArrayList<String> dictionary = new ArrayList<String>();
		if(end.length()!=start.length())
		{
			return outcome(false);
		}
		else if(start.equals(end))
		{
			stack.push(start);
			return outcome(true);
		}
		while (dict.hasNext()) {
			String x = dict.next();
			if(start.length()==x.length())
			dictionary.add(x);
		}
		if(!dictionary.contains(end)||!dictionary.contains(start))
			return outcome(false);
		for(int i = 0; i<dictionary.size(); i++)
		{
			String current = dictionary.get(i);
			int count = 0;
			for(int j = 0; j<current.length(); j++)
			{
				if(count==current.length()-1)
				{
					dictionary.remove(i);
					Stack<String> works = new Stack<String>();
					works.push(start);
					works.push(current);
					queue.offer(works);
					i--;
					if(current.equals(end))
					{
						stack.addAll(works);
						return outcome(true);
					}
				}
				if(current.charAt(j)==start.charAt(j))
					count++;
			}
		}
		while(!queue.isEmpty())
		{
			Stack<String> temp = queue.poll();
			String word = temp.peek();
			ArrayList<String> list = new ArrayList<String>();
			if(word.equals(end))
			{
				stack.addAll(temp);
				return outcome(true);
			}
			else
			{
				for(int i = 0; i<dictionary.size(); i++)
				{
					String current = dictionary.get(i);
					int count = 0;
					for(int j = 0; j<current.length(); j++)
					{
						if(count==current.length()-1)
						{
							dictionary.remove(i);
							list.add(current);
							i--;
						}
						if(current.charAt(j)==word.charAt(j))
						count++;
					}
				}
				for(int x =0; x<list.size(); x++)
				{
					Stack<String> copy = new Stack<String>();
					copy.addAll(temp);
					copy.push(list.get(x));
					queue.offer(copy);
					if(list.get(x).equals(end))
					{
						stack.addAll(copy);
						return outcome(true);
					}
				}
				
			}
		}
		return outcome(true);		
	}
	public String outcome(boolean solvable)
	{
		if(solvable)
			return "Found a ladder! >>> " + stack;
	else
		return "No ladder found between " + start + " and " + end;
		
	}
		
}
