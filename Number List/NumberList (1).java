
public class NumberList {
	private Integer[] list;
	private int listSize;
	public NumberList()
	{
		list = new Integer[2];
		listSize = 0;
	}
	public int size() 
	{
		return listSize;
	}
	public boolean isEmpty()
	{
		if(listSize==0)
			return true;
		else
			return false;
	}
	public String toString()
	{
		String representation="[";
		for(int i=0; i<listSize-1; i++)
		{
			representation+=(list[i]+", ");
		}
		if(listSize>0)
			representation+=(list[listSize-1]+"]");
		if(listSize==0)
			representation+="]";
		return representation;
	}
	private void doubleCapacity()
	{
		Integer[] duplicate = new Integer[list.length*2];
		for(int i = 0; i<list.length; i++)
		{
			duplicate[i]=list[i];
		}
		list=duplicate;
	}
	public void add(int index, Integer val)
	{
		if(index<0||index>listSize)
			throw new IndexOutOfBoundsException();
		if(list.length==listSize)
			doubleCapacity();
		for(int i =listSize-1; i>=index; i--)
		{
			list[i+1]=list[i];
		}
		list[index]=val;
		listSize++;
	}
	public boolean add(int val)
	{
		add(listSize, val);
		return true;
	}
	public Integer get(int index)
	{
		if(index<0||index>listSize)
			throw new IndexOutOfBoundsException();
		else
			return list[index];
	}
	public Integer set(int index, Integer val)
	{
		if(index<0||index>listSize)
			throw new IndexOutOfBoundsException();
		else
		{
			Integer temp = list[index];
			list[index]=val;
			return temp;
		}
	}
	public Integer remove(int index)
	{
		if(index<0||index>listSize)
			throw new IndexOutOfBoundsException();
		else
		{
			Integer removed = list[index];
			for(int i=index; i<listSize;i++)
				list[index]=list[index+1];
			list[listSize-1]=null;
			listSize--;
			return removed;
		}
	}

}
