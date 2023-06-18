import java.util.*;

public class Dijkstra {
	Graph graph;

	public Dijkstra(Graph graph) {
		this.graph = graph;
	}

	public double distance(int src, int dest) {
		dijkstra(src, dest);
		return graph.adjList[dest].distance;
	}

	private void dijkstra(int src, int dest) {
		Queue<Vertex> pq = new PriorityQueue<Vertex>();
		graph.adjList[src].distance = 0;
		pq.add(graph.adjList[src]);
		while (!graph.adjList[dest].visited) {
			if (pq.isEmpty())
				return;
			Vertex current = pq.poll();
			if (current.visited)
				continue;
			current.visited = true;
			double oldDist = -1, newDist = -1;
			for (Object i : current.edges) {
				Vertex adj = graph.adjList[(int) i];
				if (!adj.visited) {
					oldDist = current.euclideanDist(adj);
					newDist = current.distance + oldDist;
					if (adj.distance > newDist) {
						adj.prev = current.ID;
						adj.distance = newDist;
					}
					pq.add(adj);
				}
			}
		}
		// TODO Auto-generated method stub
	}

	public void shortestPath() {
		System.out.println("Distance : " + distance(graph.begin, graph.end));
		System.out.println();
		int curr = graph.adjList[graph.end].prev;
		String path = "" + graph.adjList[graph.end].ID;
		while (true) {
			if (curr == -1)
				break;
			path = curr + " -> " + path;
			curr = graph.adjList[curr].prev;
		}
		System.out.println("Path : " + path);
	}

	public static void main(String[] args) {
		Dijkstra algorithm = new Dijkstra(new Graph());
		algorithm.shortestPath();
	}

}
