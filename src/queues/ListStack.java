package queues;

import java.util.List;
import java.util.LinkedList;

public class ListStack implements Stack
{
	private final List<Object> l = new LinkedList<Object>();
	
	public void push(Object v)
	{
		l.add(v);
	}
	
	public Object pop()
	{
		if(l.isEmpty())
			return null;
		return l.remove(l.size()-1);
	}
	
	public Object peek()
	{
		if(l.isEmpty())
			return null;
		return l.get(l.size()-1);
	}
	
	public void enqueue(Object v)
	{
		push(v);
	}
	
	public Object dequeue()
	{
		if(l.isEmpty())
			return null;
		return pop();
	}
	
	public void clear()
	{
		l.clear();
	}
	
	public int size()
	{
		return l.size();
	}
	
	public boolean isEmpty()
	{
		return l.isEmpty();
	}
	
	public String toString()
	{
		return l.toString();
	}
}
