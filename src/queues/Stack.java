package queues;

public interface Stack extends Queue<Object>
{
	public void push(Object o);
	public Object pop();
	public Object peek();
	public void clear();
	public int size();
	public boolean isEmpty();
}
