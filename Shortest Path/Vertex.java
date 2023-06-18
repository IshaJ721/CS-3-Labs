import java.util.*;

public class Vertex<T> implements Comparable<T>{
	int x,y,ID, prev;
	boolean visited;
	double distance;
	
	List<Integer> edges;
	public Vertex(int ID, int x, int y)
	{
		this.x = x;
		this.y = y;
		this.ID = ID;
		edges = new ArrayList<Integer>();
		distance = Double.POSITIVE_INFINITY;
		prev = -1;
	}
	@Override
	public int compareTo(T o) {
		return (int) (this.distance - ((Vertex)o).distance);
	}
	@Override
	public String toString()
	{
		return ID + " " + distance;
	}
	public double euclideanDist(Vertex o)
	{
		return Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));
	}
	@Override
	public boolean equals(Object o)
	{
		return this.ID == ((Vertex)o).ID;
	}
}
