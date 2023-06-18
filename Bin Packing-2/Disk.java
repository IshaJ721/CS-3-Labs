import java.util.*;

public class Disk implements Comparable<Disk> {
	private int space;
	private int id;
	ArrayList<Integer> list = new ArrayList<Integer>();

	public Disk(int id) {
		space = 1_000_000;
		this.id = id;
	}

	public void add(int size) {
		space -= size;
		list.add(size);
	}

	@Override
	public int compareTo(Disk other) {
// TODO Auto-generated method stub
		if(this.getSpace()<other.getSpace())
			return 1;
		else
			return -1;
	}

	public String listToString() {
		String s = "";
		for (int i = 0; i < list.size(); i++)
			s += list.get(i) + " ";
		return s;
	}
	public int getSpace()
	{
		return this.space;
	}
	public int getId()
	{
		return this.id;
	}

}
