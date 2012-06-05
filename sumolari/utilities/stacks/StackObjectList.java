package sumolari.utilities.stacks;

import sumolari.utilities.ListObject;
import sumolari.utilities.lists.ListObjectLinked;
import sumolari.utilities.lists.ListObjectArray;
import sumolari.utilities.StackObject;
import sumolari.utilities.exceptions.StackOverflowException;
import sumolari.utilities.exceptions.ListOverflowException;

/**
 * This class is an implementation of a Stack of objects by means of a list.
 */
public class StackObjectList extends StackObject
{
	private ListObject	list;

	/**
	 * Creates a stack allowing choosing which implementation of the list want to use internally.
	 * @param implementation 0 for array implementation. Any other value for linked version.
	 */
	public StackObjectList( int implementation )
	{
		if ( implementation == 0 )
		{
			this.list = new ListObjectArray();
		}
		else
		{
			this.list = new ListObjectLinked();
		}
	}

	public StackObjectList()
	{
		this( -1 );
	}

	@Override public void push( Object x ) throws StackOverflowException
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

	@Override public Object pop()
	{
		this.list.begin();
		Object aux = this.list.get();
		this.list.remove();

		return aux;
	}

	@Override public Object top() 
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