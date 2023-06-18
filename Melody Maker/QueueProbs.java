
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProbs {

	public Queue<Integer> evenFirst(Queue<Integer> nums) {
		Queue<Integer> temp1 = new LinkedList<Integer>();
		Queue<Integer> temp2 = new LinkedList<Integer>();
		while (!nums.isEmpty()) {
			if (nums.peek() % 2 != 0)
				temp1.offer(nums.poll());
			else
				temp2.offer(nums.poll());
		}
		while (!temp2.isEmpty()) {
			nums.offer(temp2.poll());
		}
		while (!temp1.isEmpty()) {
			nums.offer(temp1.poll());
		}
		return nums;

	}

	public boolean numPalindrome(Queue<Integer> nums) {
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		while (!nums.isEmpty()) {
			int i = nums.poll();
			stack.push(i);
			queue.offer(i);
		}
		while (!stack.isEmpty()) {
			if (stack.pop() != queue.poll())
				return false;
		}
		return true;
	}

	public Stack<Integer> sieveOfEratosthenes(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 2; i<=n; i++)
			{
				queue.offer(i);
			}
		while(!queue.isEmpty())
			{
				int x = queue.poll();
				stack.push(x);
				for(int j = 0; j<queue.size();j++)
				{
					if(queue.peek()%x==0)
						queue.poll();
				}
}
		return stack;
}
}
