package queues;

public class Test2
{
	public static void main(String[] args)
	{
		VehicleListStack s = new VehicleListStack();
		
		s.push(new Vehicle("audi", 12));
		System.out.println(s.toString());
		
		s.push(new Vehicle("budi", 2));
		System.out.println(s.toString());
		
		s.push(new Vehicle("cudi", 1));
		System.out.println(s.toString());
		
		s.push(new Vehicle("dudi", 20));
		System.out.println(s.toString());
		
		s.pop();
		System.out.println(s.toString());
		
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.toString());
		System.out.println(s.size());
	}
}
