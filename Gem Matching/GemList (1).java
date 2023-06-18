
import java.util.*;

public class GemList {
	private int size;
	private int score;
	private Node head, tail;

	private class Node {
		private Gem gem;
		private Node next;
	}

	public static void main(String[] args) {
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);

		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);

		list.insertBefore(new Gem(GemType.BLUE, 20), 99); // not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);

		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);

		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);

		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);

		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);
	}

	public GemList() {
		size = 0;
		score = 0;
	}

	public int size() {
		return size;
	}

	public void draw(double y) {
		Node current = head;
		for (int i = 0; i < size; i++) {
			double x = GemGame.indexToX(i);
			current.gem.draw(x, y);
			current = current.next;
		}
	}

	public String toString() {
		String str = "";
		if (size == 0)
			return "<none>";
		else {
			str += head.gem.toString();
			Node current = head;
			if (tail != null)
			{
				current = head.next;
				str += " -> ";
			}
			for (int i = 1; i < size-1; i++) {
				if (current != null)
					str += current.gem.toString() + " -> ";
				if(current==null)
					break;
				current = current.next;
			}
			if(tail!=null)
			str += current.gem.toString();
			return str;
		}
	}

	public void insertBefore(Gem gem, int index) {
		if (head == null) {
			head = new Node();
			head.gem = gem;
		} else if (index == 0) {
			Node node = head;
			head.gem = gem;
			head.next = node;
		} else if (index >= size) {
			if (tail != null) {
				tail.next = new Node();
				tail.next.gem = gem;
				tail = tail.next;
			} else {
				tail = new Node();
				tail.gem = gem;
				head.next = tail;
			}
		}
		if (index < size && index > 0) {
			int x = 0;
			Node current = head;
			while (x + 1 < index) {
				current = current.next;
				x++;
			}
			Node temp;
			temp = current.next;
			current.next = new Node();
			current.next.gem = gem;
			current = current.next;
			current.next = temp;
		}
		size++;
	}

	public int score() {
		int totalScore = 0;
		if (head != null) {
			Node current = head;
			int x = 0;
			GemType type = current.gem.getType();
			int score = 0;
			for (int i = 0; i < size; i++) {
				x++;
				score += current.gem.getPoints();
				if (current.next!= null) {
					if (current.gem.getType() != current.next.gem.getType())
					{
						totalScore += (x * score);
						x=0;
						score = 0;
					}
				} if(current.next==null)
				{
					totalScore += (score*x);
				}
				current = current.next;
			}
		}
		return totalScore;
	}

}
