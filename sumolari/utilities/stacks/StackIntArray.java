package sumolari.utilities.stacks;

import sumolari.utilities.exceptions.StackOverflowException;
import sumolari.utilities.exceptions.SumolariExceptionManager;
import sumolari.utilities.StackInt;

/**
 * This class is an implementation of a Stack of integer numbers (int) by means of an array.
 */
public class StackIntArray extends StackInt
{
	private int[] 				array;
	private int 				top;
	private static final int 	MAX = 100;

	public StackIntArray()
	{
		this.array = new int[ StackIntArray.MAX ];
		this.top = -1;
	}

	public StackIntArray( int[] values )
	{
		this();
		
		for ( int i : values )
		{
			try 
			{
				this.push( i );
			}
			catch ( StackOverflowException soe )
			{
				SumolariExceptionManager.catchException( soe );
			}
		}
	}

	@Override public void push( int x ) throws StackOverflowException
	{
		if ( top + 1 == MAX ) throw new StackOverflowException();

		this.array[ ++this.top ] = x;
	}

	@Override public int pop() { return this.array[ top-- ]; }
	@Override public int top() { return this.array[ top ]; }
	@Override public boolean isEmpty() { return this.top == -1; }
	@Override public int size() { return this.top + 1; }

	@Override public String toString()
	{
		String output = "{ ";

		for ( int i = array.length - 1; i >= 0; i-- )
		{
			output += array[ i ] + " ";
		}

		output += " }";

		return output;
	}
}