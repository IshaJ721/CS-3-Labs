import java.util.ArrayList;

public class Catalog {
	private ArrayList <Item> list = new ArrayList<Item>();
	private String catalogName;
	public Catalog(String name)
	{
		catalogName = name;
	}
	public void add(Item item)
	{
		list.add(item);
	}
	public int size()
	{
		return list.size();
	}
	public Item get(int index)
	{
		return list.get(index);
	}
	public String getName()
	{
		return catalogName;
	}

}
