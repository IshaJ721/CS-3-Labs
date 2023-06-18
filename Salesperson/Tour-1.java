import java.io.*;
import java.util.*;

public class Tour {
	Queue<Point> tour = new LinkedList<Point>();
	int size;
	Node head, tail;

	private class Node {
		Point p;
		Node next;
	}

	/** create an empty tour */
	public Tour() {
		head = null;
		tail = null;
		size = 0;
	}

	/** create a four-point tour, for debugging */
	public Tour(Point a, Point b, Point c, Point d) {
		head = new Node();
		head.p = a;
		head.next = new Node();
		tail = head.next;
		tail.p = b;
		tail.next = new Node();
		tail = tail.next;
		tail.p = c;
		tail.next = new Node();
		tail = tail.next;
		tail.p = d;
		tail.next = head;
		size = 4;
	}

	/** print tour (one point per line) to std output */
	public void show() {
		Node current = head;
		for (int i = 0; i < size; i++) {
			System.out.println(current.p.toString());
			current = current.next;
		}
	}

	/** draw the tour using StdDraw */
	public void draw() {
		Node current = head;
		for (int i = 0; i < size(); i++) {
			current.p.drawTo(current.next.p);
			current = current.next;
		}
	}

	/** return number of nodes in the tour */
	public int size() {
		return size;
	}

	/**
	 * return the total distance "traveled", from start to all nodes and back to
	 * start
	 */
	public double distance() {
		Node current = head;
		Node temp = head;
		current = head.next;
		double total = 0;
		for (int i = 0; i < size; i++) {
			total += current.p.distanceTo(temp.p);
			temp = temp.next;
			current = current.next;
		}
		return total;
	}

	/** insert p using nearest neighbor heuristic */
	public void insertNearest(Point p) {
		if (head == null) {
			head = new Node();
			head.p = p;
			tail = head;
		}
		if (head.next == null) {
			head.next = new Node();
			head.next.p = p;
			tail = head.next;
		} else {
			double minDist = head.p.distanceTo(p);
			Node current = head.next;
			Node min = head;
			for (int i = 0; i < size - 1; i++) {
				if (current.p.distanceTo(p) < minDist) {
					min = current;
					minDist = current.p.distanceTo(p);
				}
				current = current.next;
			}

			Node temp;
			if (min.next != null) {
				temp = min.next;
				min.next = new Node();
				min.next.p = p;
				min.next.next = temp;
			} else {
				min.next = new Node();
				min.next.p = p;
				min.next = tail;
			}
		}
		size++;
	}

	/** insert p using smallest increase heuristic */
	public void insertSmallest(Point p) {
		if (head == null) {
			head = new Node();
			head.p = p;
			tail = head;
		}
		if (head.next == null) {
			head.next = new Node();
			head.next.p = p;
			tail = head.next;
		} else {
			Node min = head;
			Node current = head;
			double difference = (current.p.distanceTo(p) + current.next.p.distanceTo(p))
					- current.p.distanceTo(current.next.p);
			while (current.next != null) {
				if ((current.p.distanceTo(p) + current.next.p.distanceTo(p))
						- current.p.distanceTo(current.next.p) < difference) {
					difference = (current.p.distanceTo(p) + current.next.p.distanceTo(p))
							- current.p.distanceTo(current.next.p);
					min = current;
				}
				current = current.next;
			}
			Node temp;
			temp = min.next;
			min.next = new Node();
			min.next.p = p;
			min.next.next = temp;
		}
		size++;
	}
}
