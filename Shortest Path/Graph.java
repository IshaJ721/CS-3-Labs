import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
	int V, E, begin, end;
	Vertex[] adjList;

	public Graph() {
		try {
			Scanner input = new Scanner(new File("input6.txt"));
			V = input.nextInt();
			adjList = new Vertex[V];
			E = input.nextInt();
			input.nextLine();
			for (int i = 0; i < V; i++)
				adjList[i] = new Vertex(input.nextInt(), input.nextInt(), input.nextInt());
			for (int i = 0; i < E; i++)
				adjList[input.nextInt()].edges.add(input.nextInt());
			begin = input.nextInt();
			end = input.nextInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString() {
		String str = "";
		for (Vertex i : adjList)
			str += i.toString() + "\n";
		return str;
	}

	public double distance(int from, int to) {
		return adjList[from].euclideanDist(adjList[to]);
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		System.out.println(graph.toString());
	}
}
