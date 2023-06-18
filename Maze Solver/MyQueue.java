import java.util.*;

public class MyQueue<T> implements QueueADT<T> {

	LinkedList<T> queue;
	public MyQueue()
	{
		queue = new LinkedList<T>();
	}
	@Override
	public void offer(T s) {
		queue.offer(s);
		// TODO Auto-generated method stub
	}
	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return queue.poll();
	}
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return queue.peek();
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		queue.clear();
	}
	
	

}
