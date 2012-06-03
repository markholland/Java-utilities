package sumolari.utilities.stacks;

import sumolari.utilities.ListInt;
import sumolari.utilities.lists.ListIntLinked;
import sumolari.utilities.lists.ListIntArray;
import sumolari.utilities.StackInt;
import sumolari.utilities.exceptions.StackOverflowException;
import sumolari.utilities.exceptions.ListOverflowException;

/**
 * This class is not documented. See the parent class <code>StackInt</code> for more information.
 */

public class StackIntList extends StackInt
{
	private ListInt	list;

	/**
	 * Creates a stack allowing choosing which implementation of the list want to use internally.
	 * @param implementation 0 for array implementation. Any other value for linked version.
	 */
	public StackIntList( int implementation )
	{
		if ( implementation == 0 )
		{
			this.list = new ListIntArray();
		}
		else
		{
			this.list = new ListIntLinked();
		}
	}

	public StackIntList()
	{
		this( -1 );
	}

	@Override public void push( int x ) throws StackOverflowException
	{
		this.list.begin();
		
		try
		{
			this.list.insert( x );
		}
		catch ( ListOverflowException loe )
		{
			throw new StackOverflowException();
		}
	}

	@Override public int pop()
	{
		this.list.begin();
		int aux = this.list.get();
		this.list.remove();

		return aux;
	}

	@Override public int top() 
	{
		this.list.begin();
		return this.list.get(); 
	}

	@Override public boolean isEmpty() { return this.list.isEmpty(); }

	@Override public int size() { return this.list.size(); }

	@Override public String toString()
	{
		return this.list.toString();
	}

}