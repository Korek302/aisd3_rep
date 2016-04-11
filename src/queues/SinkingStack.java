package queues;

import java.util.List;
import java.util.LinkedList;

public class SinkingStack implements Stack
{
	private final List<Vehicle> l;
	int limit = 0;
	
	public SinkingStack(int n)
	{
		this(new LinkedList<Vehicle>(), n);
	}
	
	public SinkingStack(List<Vehicle> list, int n)
	{
		if(n < 0)
			n = 0;
		limit = n;
		l = list;
		
		while(l.size() > limit)
		{
			l.remove(l.size());
		}
	}
	
	
	public void push(Object v)
	{
			if(l.size() >= limit && !l.isEmpty())
				l.remove(0);
			
			if(limit != 0)
				l.add((Vehicle) v);
	}
	
	public Object pop()
	{
		return l.isEmpty()?null:l.remove(l.size()-1);
	}
	
	public Object peek()
	{
		return l.isEmpty()?null:l.get(l.size()-1);
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
	
	public void enqueue(Object o)
	{
		push(o);
	}
	
	public Object dequeue()
	{
		return pop();
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