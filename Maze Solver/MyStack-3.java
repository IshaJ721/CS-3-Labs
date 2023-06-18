import java.util.*;

public class MyStack {
	Square[] stack;
	private int size;
	public MyStack()
	{
		this(2);
	}
	public MyStack(int initCap)
	{
		size = 0;
		stack = new Square[5];
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
	public Square peek()
	{
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack[size-1];
	}
	public Square pop()
	{	
		size--;
		if(isEmpty())
			throw new EmptyStackException();
		else
		{	
			Square removed = stack[size];
			stack[size]=null;
			return removed;
		}
	}
	public void push(Square item)
	{
        if(size>=stack.length)
        	doubleCapacity();
        stack[size] = item;
        size++;
	}
	private void doubleCapacity()
	{
		Square[] doubled = new Square[(stack.length)*2];
		for(int i = 0; i<stack.length; i++)
			doubled[i] = stack[i];
		stack = doubled;
	}
	@Override
	public String toString()
	{
		String s = "";
		for(int i = size-1; i>0; i--)
			s+=stack[i] + " \n";
		return s;
	}

}
