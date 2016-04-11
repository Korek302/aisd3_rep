package queues;

public class Test4
{
	public static void main(String[] args)
	{
		LimitedQueue q = new LimitedQueue(2);
		
		q.enqueue(new Vehicle("audi", 12));
		q.enqueue(new Vehicle("budi", 10));
		q.enqueue(new Vehicle("cudi", 2));
		
		System.out.println(q.toString());
		
		
		System.out.println(q.toString());
			}

}
