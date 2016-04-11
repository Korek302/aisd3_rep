package queues;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Converter
{
	public List<Character> tokenize() throws IOException 
	{
		  StreamTokenizer tokenizer = new StreamTokenizer(new 
				  BufferedReader(new InputStreamReader(System.in)));
		  tokenizer.eolIsSignificant(true);
		  tokenizer.ordinaryChar('-');
		  tokenizer.ordinaryChar('/');
		  List<Character> tokBuf = new ArrayList<Character>();
		  while (tokenizer.nextToken() != StreamTokenizer.TT_EOL) 
		  {
		    switch(tokenizer.ttype) 
		    {
		     	case StreamTokenizer.TT_NUMBER:
		     		tokBuf.add((char) tokenizer.nval);
		     		break;
		     	default:
		     		tokBuf.add((char) tokenizer.ttype);
		    }
		  }
		  return tokBuf; 
	}
	
	public List<Object> convert(List<Character> l) throws IOException
	{
		ListStack stack = new ListStack();
		List<Character> out = new ArrayList<Character>();
		List<Character> in = l;
		for(int i = 0; i < in.size(); i++)
		{
			switch(in.get(i))
			{
			case '+':
			case '-':
				while(!stack.isEmpty() && ((Character)stack.peek() == '+' 
				|| (Character)stack.peek() == '-' || (Character)stack.peek() == '*' 
				|| (Character)stack.peek() == '/' || (Character)stack.peek() == '^'))
				{
					out.add((Character) stack.pop());
				}
				stack.push(in.get(i));
				break;
			case '*':
			case '/':
				while(!stack.isEmpty() && (((Character)stack.peek() == '*' 
				|| (Character)stack.peek() == '/') || (Character)stack.peek() == '^'))
				{
					out.add((Character) stack.pop());
				}
				stack.push(in.get(i));
				break;
			case '^':
				while(!stack.isEmpty() && (Character)stack.peek() == '^')
				{
					out.add((Character) stack.pop());
				}
				stack.push(in.get(i));
				break;
			case '(':
				stack.push(in.get(i));
				break;
			case ')':
				while((Character)stack.peek() != '(')
				{
					out.add((Character)stack.pop());
				}
				stack.pop();
				
				if(!stack.isEmpty()&&((Character)stack.peek() == '#' 
						|| (Character)stack.peek() == '$'))
					out.add((Character)stack.pop());
				break;
			case '#':
			case '$':
				stack.push(in.get(i));
				break;
			default:
				out.add(in.get(i));
				break;
			}
		}
		while(!stack.isEmpty())
			out.add((Character)stack.pop());
		
		List<Object> out2 = new ArrayList<Object>();
		for(int i = 0; i < out.size(); i++)
		{
			if(out.get(i)!='+' && out.get(i)!='-' && out.get(i)!='*' 
					&& out.get(i)!='/' && out.get(i)!='^' && out.get(i)!='#'
					&& out.get(i)!='$')
				out2.add((Double)((out.get(i)-'0')+48.0));
			else
				out2.add(out.get(i));
		}
		
		return out2;
	}
}
