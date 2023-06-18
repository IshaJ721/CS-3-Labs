
public class MazeSolverStack extends MazeSolver {
	MyStack stack;
	public MazeSolverStack(Maze maze) {
		super(maze);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void add(Square s)
	{
		stack.push(s);
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		stack = new MyStack();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Square next() {
		// TODO Auto-generated method stub
		return stack.pop();
	}

}
