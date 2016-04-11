package queues;

import java.util.List;
import java.util.LinkedList;

public class VehicleListStack implements Stack
{
	private final List<Vehicle> l = new LinkedList<>();
	
	public void push(Object v)
	{
		l.add((Vehicle)v);
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
		//return l.toString();
		
		StringBuffer buf = new StringBuffer();
		buf.append('[');
		if(!l.isEmpty())
		{
			for(int i = 0; i < l.size(); i++)
			{
				buf.append(l.get(i).model).append(l.get(i).age).append(", ");
			}
			buf.setLength(buf.length()-2);
		}
		buf.append(']');
		return buf.toString();
	}
}
