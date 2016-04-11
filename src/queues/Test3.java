package queues;

import java.io.IOException;

public class Test3
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Avaliable actions: ");
		System.out.println("+ - add");
		System.out.println("- - substract");
		System.out.println("* - multiply");
		System.out.println("/ - divide");
		System.out.println("^ - power");
		System.out.println("# - square root");
		System.out.println("$ - logarithm");
		System.out.println("Enter expression: ");
		
		Calculator c1 = new Calculator();
		c1.evaluate();
		
	}
}
