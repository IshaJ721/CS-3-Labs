import java.util.*;

public class MyStack {
	Integer[] stack;
	private int size;
	public MyStack()
	{
		this(2);
	}
	public MyStack(int initCap)
	{
		size = initCap;
		stack = new Integer[initCap];
	}
	public boolean isEmpty()
	{
		boolean empty = true;
		for(int i = 0; i<stack.length; i++)
		{
			empty = (stack[i]==null);
			if(empty==false)
				break;
		}	
		return empty;
	}
	public Integer peek()
	{
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack[size-1];
	}
	public Integer pop()
	{	
		size--;
		if(isEmpty())
			throw new EmptyStackException();
		else
		{	
			Integer removed = stack[size];
			stack[size]=0;
			return removed;
		}
	}
	public void push(Integer item)
	{
        if(size>=stack.length)
        	doubleCapacity();
        stack[size] = item;
        size++;
	}
	private void doubleCapacity()
	{
		Integer[] doubled = new Integer[(stack.length)*2];
		for(int i = 0; i<stack.length; i++)
			doubled[i] = stack[i];
		stack = doubled;
	}
	@Override
	public String toString()
	{
		String s = "";
		for(int i = size-1; i>0; i--)
			s+=stack[i] + "\n";
		return s;
	}

}
