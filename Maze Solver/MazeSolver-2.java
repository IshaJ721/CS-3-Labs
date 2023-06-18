import java.util.*;

public abstract class MazeSolver {
	Maze maze;
	boolean solved = false, solvable = true;

	public MazeSolver(Maze maze) {
		this.maze = maze;
		makeEmpty();
		add(maze.getStart());
	}

	public abstract void makeEmpty();

	public abstract boolean isEmpty();

	public abstract void add(Square s);

	public abstract Square next();

	public boolean isSolved() {
		return (solved || !solvable);
	}

	public void step() {
		if (!isEmpty()) {
			Square current = next();
			current.setStatus(Square.EXPLORED);
			if (current == maze.getExit())
				solved = true;
			else {
				List<Square> list;
				list = maze.getNeighbors(current);
				for (int x = 0; x < list.size(); x++) {
					if ((list.get(x).getStatus() == Square.UNKNOWN) && !(list.get(x).getType() == Square.WALL))
					{
						add(list.get(x));
						//if(list.get(x).previous==null)
							list.get(x).previous=current;
							list.get(x).setStatus(Square.WORKING);
					}
				}			
			}
			if(isEmpty())
				solvable=false;
		} 
	}

	public String getPath() {
		Queue<String> queue = new LinkedList<String>();
		if (solvable && solved)
		{
			Square current = this.maze.getExit();
			while(current!=null)
			{
				queue.offer("[" + current.getRow() + "," + current.getCol() + "] ");
				current = current.getPrevious();
			}
			String s = "";
			while(!queue.isEmpty())
				s+=queue.poll();
			return s;
		}
		if (solvable)
		{
			return "The maze isn't solved yet.";
		}
		return "No such path exists";
	}

	public void solve() {
		if (!isSolved())
			step();
	}

}
