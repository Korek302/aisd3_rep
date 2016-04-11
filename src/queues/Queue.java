package queues;

public interface Queue<T>
{
	public void enqueue(T t);
	public Object dequeue();
	public void clear();
	public int size();
	public boolean isEmpty();
}
