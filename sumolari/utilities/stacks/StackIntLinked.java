package sumolari.utilities.stacks;

import sumolari.utilities.nodes.NodeInt;
import sumolari.utilities.StackInt;

/**
 * This class is not documented. See the parent class <code>StackInt</code> for more information.
 */

public class StackIntLinked extends StackInt
{
	private NodeInt	top;
	private int 	size;

	public StackIntLinked()
	{
		this.top = null;
		this.size = 0;
	}

	public StackIntLinked( int[] values )
	{
		this();

		for ( int i : values )
		{
			this.push( i );
		}
	}

	@Override public void push( int x )
	{
		this.top = new NodeInt( x, top );
		this.size++;
	}

	@Override public int pop() 
	{
		int x = this.top.value();
		
		this.top = this.top.next();
		this.size--;

		return x;
	}

	@Override public int top() { return this.top.value(); }
	@Override public boolean isEmpty() { return ( this.top == null ); }
	@Override public int size() { return this.size; }

	@Override public String toString()
	{
		NodeInt node = top;
		String output = "{";

		while ( node != null )
		{
			output += node.value() + " ";
			node = node.next();
		}

		output += "}";

		return output;
	}

}