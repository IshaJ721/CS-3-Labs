import java.util.*;

public class Runner {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(10);
		queue.offer(10);
		queue.offer(32);
		queue.offer(10);
		queue.offer(10);
		QueueProbs test = new QueueProbs();
		System.out.println(test.evenFirst(queue));
		System.out.println(test.numPalindrome(queue));
		System.out.println(test.sieveOfEratosthenes(10));

	}
}
