
public class MazeSolverQueue extends MazeSolver {
	MyQueue<Square> queue;

	public MazeSolverQueue(Maze maze) {
		super(maze);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		queue = new MyQueue();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	@Override
	public void add(Square s) {
		// TODO Auto-generated method stub
		queue.offer(s);
	}

	@Override
	public Square next() {
		// TODO Auto-generated method stub
		return queue.poll();
	}
	

}
