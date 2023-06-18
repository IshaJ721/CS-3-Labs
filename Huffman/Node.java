
public class Node implements Comparable<Node> {
	public int frequency;
	public int value;
	public Node right;
	public Node left;
	public Node(int freq) {
		this.frequency = freq;
	}

	@Override
	public int compareTo(Node o) {
		return this.frequency-o.frequency;
	}
	@Override
	public String toString()
	{
		return Character.toString((char)value);
	}

}