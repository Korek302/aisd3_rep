package queues;

import java.util.List;
import java.io.IOException;

public class Calculator
{
	Converter converter = new Converter();
	
	void evaluate() throws IOException
	{
		List<Character> l = converter.tokenize();
		List<Object> onp = converter.convert(l);
		
		System.out.println("RPN representation: ");
		System.out.println(onp.toString());
		Stack stack = new ListStack();
		Object el;
		while(!onp.isEmpty())
		{
			el = onp.remove(0);
			if(el instanceof Double)
				stack.push(el);
			else
			{
				if(stack.peek() == null)
				{
					return;
				}
				else if((Character)el == '#' 
						|| (Character)el == '$')
					{
						double arg = (Double)stack.pop();
						switch((Character)el)
						{
						case '#':
							stack.push(Math.sqrt(arg));
							break;
						case '$':
							stack.push(Math.log10(arg));
							break;
						}
					}
					else
					{
						double right = (Double)stack.pop();
						if(!stack.isEmpty())
						{
						double left = (Double)stack.pop();
						switch((Character)el)
						{
						case '+' : stack.push(left+right);
						break;
						case '-' : stack.push(left-right);
						break;
						case '*' : stack.push(left*right);
						break;
						case '/' : stack.push(left/right);
						break;
						case '^' : stack.push(Math.pow(left, right));
						}
						}
					}
			}
		}
		System.out.println("Result: ");
		System.out.println(stack.pop());
	}
}
